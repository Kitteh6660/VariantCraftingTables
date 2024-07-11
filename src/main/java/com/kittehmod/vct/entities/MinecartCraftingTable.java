package com.kittehmod.vct.entities;

import com.kittehmod.vct.blocks.VCTCraftingTableBlock;
import com.kittehmod.vct.container.MinecartCraftingMenu;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecartContainer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.MinecartItem;

public class MinecartCraftingTable extends AbstractMinecartContainer
{
	public static final EntityDataAccessor<BlockState> DATA_BLOCK_STATE = SynchedEntityData.defineId(MinecartCraftingTable.class, EntityDataSerializers.BLOCK_STATE);
		
	public MinecartCraftingTable(EntityType<? extends MinecartCraftingTable> workbenchCart, Level world) {
		super(workbenchCart, world);
	}

	public MinecartCraftingTable(Level level, double x, double y, double z, Block block) {
		super(getEntitySubtype(), x, y, z, level);
		this.setCraftingTableBlock(block);
	}

	public InteractionResult interact(Player player, InteractionHand hand) {
		InteractionResult ret = super.interact(player, hand);
		if (ret.consumesAction()) return ret;
		player.openMenu(this);
		if (!player.level().isClientSide()) {
			return InteractionResult.CONSUME;
		} else {
			return InteractionResult.SUCCESS;
		}
	}

	@Override
	public Component getName() {
		return VCTCraftingTableBlock.TITLE;
	}
	
	@Override
	public BlockState getDisplayBlockState() {
		return this.getDefaultDisplayBlockState();
	}

	@Override
	public BlockState getDefaultDisplayBlockState() {
		return this.entityData.get(DATA_BLOCK_STATE);
	}

	public int getDefaultDisplayTileOffset() {
		return 8;
	}

	public AbstractContainerMenu createMenu(int cid, Inventory playerInventoryIn) {
		return new MinecartCraftingMenu(cid, playerInventoryIn, ContainerLevelAccess.create(this.level(), this.blockPosition()), this);
	}

	@Override
	public Type getMinecartType() {
		return AbstractMinecartContainer.Type.CHEST; // Arbitrarily set but its only purpose is to make the errors shut up.
	}

	@Override
    public ItemStack getItem(int index) {
		return new ItemStack(this.getCartItem());
    }
	
	@Override
	public ItemStack getPickResult() {
		return new ItemStack(this.getCartItem());
	}
	
	@Override
	public int getContainerSize() {
		return 0;
	}
	
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void destroy(DamageSource source) {
		this.kill();
		if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
			ItemStack itemstack = new ItemStack(this.getDropItem());
			if (this.hasCustomName()) {
				itemstack.setHoverName(this.getCustomName());
			}
			this.spawnAtLocation(itemstack);
		}
		if (!source.is(DamageTypes.EXPLOSION) && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
			this.spawnAtLocation(this.getDisplayBlockState().getBlock());
		}
	}
	
	@Override
	protected Item getDropItem() {
		return Items.MINECART;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_BLOCK_STATE, Blocks.CRAFTING_TABLE.defaultBlockState());
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putString("Type", ForgeRegistries.BLOCKS.getKey(getCraftingTableBlock()) != null ? ForgeRegistries.BLOCKS.getKey(getCraftingTableBlock()).toString() : ForgeRegistries.BLOCKS.getKey(Blocks.CRAFTING_TABLE).toString());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {
		if (compound.contains("Type")) {
			this.setCraftingTableBlock(ForgeRegistries.BLOCKS.getValue(ResourceLocation.tryParse(compound.getString("Type"))));
		}
	}

	private static EntityType<MinecartCraftingTable> getEntitySubtype() {
		return VCTRegistry.CRAFTING_TABLE_MINECART;
	}

	public Block getCraftingTableBlock() {
		return this.entityData.get(DATA_BLOCK_STATE).getBlock();
	}
	public void setCraftingTableBlock(Block newBlock) {
		this.entityData.set(DATA_BLOCK_STATE, newBlock.defaultBlockState());
	}
	
	public Item getCartItem() {
		String id = ForgeRegistries.BLOCKS.getKey(this.getCraftingTableBlock()).toString();
		if (this.getCraftingTableBlock() == Blocks.CRAFTING_TABLE) {
			return ForgeRegistries.ITEMS.getValue(new ResourceLocation("vct:oak_crafting_table_minecart"));
		}
		else {
			ResourceLocation res = new ResourceLocation(id + "_minecart");
			return ForgeRegistries.ITEMS.getValue(res);
		}
	}

}
