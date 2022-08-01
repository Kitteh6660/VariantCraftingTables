package kittehmod.variant_crafting_tables.entities;

import kittehmod.variant_crafting_tables.blocks.VCTBlocks;
import kittehmod.variant_crafting_tables.blocks.VCTCraftingTableBlock;
import kittehmod.variant_crafting_tables.container.MinecartCraftingMenu;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecartContainer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

public class MinecartCraftingTable extends AbstractMinecartContainer
{
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(MinecartCraftingTable.class, EntityDataSerializers.INT);

	public MinecartCraftingTable(EntityType<? extends MinecartCraftingTable> workbenchCart, Level world) {
		super(workbenchCart, world);
	}

	public MinecartCraftingTable(Level level, double x, double y, double z) {
		super(getEntitySubtype(), x, y, z, level);
	}

	public InteractionResult interact(Player player, InteractionHand hand) {
		InteractionResult ret = super.interact(player, hand);
		if (ret.consumesAction()) return ret;
		player.openMenu(this);
		if (!player.level.isClientSide) {
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
		return this.getCraftingTableType().block.defaultBlockState();
	}

	public int getDefaultDisplayTileOffset() {
		return 8;
	}

	public AbstractContainerMenu createMenu(int cid, Inventory playerInventoryIn) {
		return new MinecartCraftingMenu(cid, playerInventoryIn, ContainerLevelAccess.create(this.level, this.blockPosition()), this);
	}

	@Override
	public Type getMinecartType() {
		return AbstractMinecartContainer.Type.CHEST; // Arbitrarily set but its only purpose is to make the errors shut up.
	}

	@Override
    public ItemStack getCartItem() {
		return new ItemStack(this.getCraftingTableType().getCartItem());
    }
	
	@Override
	public ItemStack getPickResult() {
		return new ItemStack(this.getCraftingTableType().getCartItem());
	}
	
	@Override
	public int getContainerSize() {
		return 9;
	}
	
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void destroy(DamageSource source) {
		super.destroy(source);
		if (!source.isExplosion() && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
			this.spawnAtLocation(this.getDisplayBlockState().getBlock());
		}
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_TYPE, 0);
	}

	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putString("Type", this.getCraftingTableType().getCraftingTable().getRegistryName().toString());
	}

	protected void readAdditionalSaveData(CompoundTag compound) {
		if (compound.contains("Type", 8)) {
			this.setCraftingTableType(MinecartCraftingTable.CraftingTableType.byName(compound.getString("Type")));
		}
	}
	
	public MinecartCraftingTable.CraftingTableType getCraftingTableType() {
		return MinecartCraftingTable.CraftingTableType.byId(this.entityData.get(DATA_ID_TYPE));
	}

	public void setCraftingTableType(CraftingTableType type) {
		this.entityData.set(DATA_ID_TYPE, type.ordinal());
	}

	private static EntityType<MinecartCraftingTable> getEntitySubtype() {
		return VCTEntities.CRAFTING_TABLE_MINECART.get();
	}

	public static enum CraftingTableType
	{
		// Vanilla
		OAK(Blocks.CRAFTING_TABLE),
		SPRUCE(VCTBlocks.SPRUCE_CRAFTING_TABLE.get()),
		BIRCH(VCTBlocks.BIRCH_CRAFTING_TABLE.get()),
		JUNGLE(VCTBlocks.JUNGLE_CRAFTING_TABLE.get()),
		ACACIA(VCTBlocks.ACACIA_CRAFTING_TABLE.get()),
		DARK_OAK(VCTBlocks.DARK_OAK_CRAFTING_TABLE.get()),
		MANGROVE(VCTBlocks.MANGROVE_CRAFTING_TABLE.get()),
		CRIMSON(VCTBlocks.CRIMSON_CRAFTING_TABLE.get()),
		WARPED(VCTBlocks.WARPED_CRAFTING_TABLE.get()),
		// Biomes o' Plenty
		BOP_CHERRY(VCTBlocks.BOP_CHERRY_CRAFTING_TABLE.get()),
		BOP_DEAD(VCTBlocks.BOP_DEAD_CRAFTING_TABLE.get()),
		BOP_FIR(VCTBlocks.BOP_FIR_CRAFTING_TABLE.get()),
		BOP_HELLBARK(VCTBlocks.BOP_HELLBARK_CRAFTING_TABLE.get()),
		BOP_JACARANDA(VCTBlocks.BOP_JACARANDA_CRAFTING_TABLE.get()),
		BOP_MAGIC(VCTBlocks.BOP_MAGIC_CRAFTING_TABLE.get()),
		BOP_MAHOGANY(VCTBlocks.BOP_MAHOGANY_CRAFTING_TABLE.get()),
		BOP_PALM(VCTBlocks.BOP_PALM_CRAFTING_TABLE.get()),
		BOP_REDWOOD(VCTBlocks.BOP_REDWOOD_CRAFTING_TABLE.get()),
		BOP_UMBRAN(VCTBlocks.BOP_UMBRAN_CRAFTING_TABLE.get()),
		BOP_WILLOW(VCTBlocks.BOP_WILLOW_CRAFTING_TABLE.get()),
		// Twilight Forest
		CANOPY(VCTBlocks.CANOPY_CRAFTING_TABLE.get()),
		DARKWOOD(VCTBlocks.DARKWOOD_CRAFTING_TABLE.get()),
		TWILIGHT_MANGROVE(VCTBlocks.TWILIGHT_MANGROVE_CRAFTING_TABLE.get()),
		MINEWOOD(VCTBlocks.MINEWOOD_CRAFTING_TABLE.get()),
		SORTINGWOOD(VCTBlocks.SORTINGWOOD_CRAFTING_TABLE.get()),
		TIMEWOOD(VCTBlocks.TIMEWOOD_CRAFTING_TABLE.get()),
		TRANSWOOD(VCTBlocks.TRANSWOOD_CRAFTING_TABLE.get()),
		TWILIGHT_OAK(VCTBlocks.TWILIGHT_OAK_CRAFTING_TABLE.get()),
		TOWERWOOD(VCTBlocks.TOWERWOOD_CRAFTING_TABLE.get()),
		// Team Abnormals
		ASPEN(VCTBlocks.ASPEN_CRAFTING_TABLE.get()),
		GRIMWOOD(VCTBlocks.GRIMWOOD_CRAFTING_TABLE.get()),
		KOUSA(VCTBlocks.KOUSA_CRAFTING_TABLE.get()),
		MORADO(VCTBlocks.MORADO_CRAFTING_TABLE.get()),
		ROSEWOOD(VCTBlocks.ROSEWOOD_CRAFTING_TABLE.get()),
		YUCCA(VCTBlocks.YUCCA_CRAFTING_TABLE.get()),
		MAPLE(VCTBlocks.MAPLE_CRAFTING_TABLE.get()),
		BAMBOO(VCTBlocks.BAMBOO_CRAFTING_TABLE.get()),
		AZALEA(VCTBlocks.AZALEA_CRAFTING_TABLE.get()),
		POISE(VCTBlocks.POISE_CRAFTING_TABLE.get()),
		CHERRY(VCTBlocks.CHERRY_CRAFTING_TABLE.get()),
		WILLOW(VCTBlocks.WILLOW_CRAFTING_TABLE.get()),
		WISTERIA(VCTBlocks.WISTERIA_CRAFTING_TABLE.get()),
		DRIFTWOOD(VCTBlocks.DRIFTWOOD_CRAFTING_TABLE.get()),
		RIVER(VCTBlocks.RIVER_CRAFTING_TABLE.get()),
		// Team Aurora
		JACARANDA(VCTBlocks.JACARANDA_CRAFTING_TABLE.get()),
		REDBUD(VCTBlocks.REDBUD_CRAFTING_TABLE.get()),
		CYPRESS(VCTBlocks.CYPRESS_CRAFTING_TABLE.get()),
		BROWN_MUSHROOM(VCTBlocks.BROWN_MUSHROOM_CRAFTING_TABLE.get()),
		RED_MUSHROOM(VCTBlocks.RED_MUSHROOM_CRAFTING_TABLE.get()),
		GLOWSHROOM(VCTBlocks.GLOWSHROOM_CRAFTING_TABLE.get()),
		// Prehistoric Fauna
		ARAUCARIA(VCTBlocks.ARAUCARIA_CRAFTING_TABLE.get()),
		HEIDIPHYLLUM(VCTBlocks.HEIDIPHYLLUM_CRAFTING_TABLE.get()),
		LIRIODENDRITES(VCTBlocks.LIRIODENDRITES_CRAFTING_TABLE.get()),
		METASEQUOIA(VCTBlocks.METASEQUOIA_CRAFTING_TABLE.get()),
		PROTOJUNIPEROXYLON(VCTBlocks.PROTOJUNIPEROXYLON_CRAFTING_TABLE.get()),
		PROTOPICEOXYLON(VCTBlocks.PROTOPICEOXYLON_CRAFTING_TABLE.get()),
		ZAMITES(VCTBlocks.ZAMITES_CRAFTING_TABLE.get()),
		// Ceilands
		CEILTRUNK(VCTBlocks.CEILTRUNK_CRAFTING_TABLE.get()),
		LUZAWOOD(VCTBlocks.LUZAWOOD_CRAFTING_TABLE.get()),
		// Ecologics
		ECO_AZALEA(VCTBlocks.ECO_AZALEA_CRAFTING_TABLE.get()),
		ECO_FLOWERING_AZALEA(VCTBlocks.ECO_FLOWERING_AZALEA_CRAFTING_TABLE.get()),
		ECO_COCONUT(VCTBlocks.ECO_COCONUT_CRAFTING_TABLE.get()),
		ECO_WALNUT(VCTBlocks.ECO_WALNUT_CRAFTING_TABLE.get()),
		// End's Phantasm
		EBONY(VCTBlocks.EBONY_CRAFTING_TABLE.get()),
		PREAM(VCTBlocks.PREAM_CRAFTING_TABLE.get()),
		// Undergarden
		GRONGLE(VCTBlocks.GRONGLE_CRAFTING_TABLE.get()),
		SMOGSTEM(VCTBlocks.SMOGSTEM_CRAFTING_TABLE.get()),
		WIGGLEWOOD(VCTBlocks.WIGGLEWOOD_CRAFTING_TABLE.get()),
		// Nether's Exoticism
		JABOTICABA(VCTBlocks.JABOTICABA_CRAFTING_TABLE.get()),
		RAMBOUTAN(VCTBlocks.RAMBOUTAN_CRAFTING_TABLE.get()),		
		// Miscellaneous
		AZURE(VCTBlocks.AZURE_CRAFTING_TABLE.get()),
		FAIRY_RING_MUSHROOM(VCTBlocks.FAIRY_RING_MUSHROOM_CRAFTING_TABLE.get()),
		//NETHERWOOD(VCTBlocks.NETHERWOOD_CRAFTING_TABLE.get()),
		PETRIFIED(VCTBlocks.PETRIFIED_CRAFTING_TABLE.get()),
		QUARK_AZALEA(VCTBlocks.QUARK_AZALEA_CRAFTING_TABLE.get()),
		QUARK_BLOSSOM(VCTBlocks.QUARK_BLOSSOM_CRAFTING_TABLE.get()),
		GINGERBREAD(VCTBlocks.GINGERBREAD_CRAFTING_TABLE.get()),
		STRIPPED_BAMBOO(VCTBlocks.STRIPPED_BAMBOO_CRAFTING_TABLE.get()),
		TWISTED(VCTBlocks.TWISTED_CRAFTING_TABLE.get());
		
		private final Block block;
		private final String name;

		CraftingTableType(Block craftingTable) {
			this.block = craftingTable;
			this.name = craftingTable.getRegistryName().toString();
		}

		public Block getCraftingTable() {
			return this.block;
		}
		
		public String getName() {
			return this.name;
		}
		
		public Block getCartTable() {
			return this.block;
		}
		
		public Item getCartItem() {
			if (block == Blocks.CRAFTING_TABLE) {
				return ForgeRegistries.ITEMS.getValue(new ResourceLocation("variant_crafting_tables:oak_crafting_table_minecart"));
			}
			else {
				ResourceLocation res = new ResourceLocation(block.getRegistryName().toString() + "_minecart");
				return ForgeRegistries.ITEMS.getValue(res);
			}
		}

		public static MinecartCraftingTable.CraftingTableType byId(int id) {
			MinecartCraftingTable.CraftingTableType[] acraftingtable$type = values();
			if (id < 0 || id >= acraftingtable$type.length) {
				id = 0;
			}
			return acraftingtable$type[id];
		}
		
		public static MinecartCraftingTable.CraftingTableType byName(String name) {
			MinecartCraftingTable.CraftingTableType[] acraftingtable$type = values();

			for(int i = 0; i < acraftingtable$type.length; ++i) {
				if (acraftingtable$type[i].getName().equalsIgnoreCase(name)) {
					return acraftingtable$type[i];
				}
			}
			return acraftingtable$type[0];
		}
	}

}
