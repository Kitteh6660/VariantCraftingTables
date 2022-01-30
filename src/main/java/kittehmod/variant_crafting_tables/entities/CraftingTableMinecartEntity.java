package kittehmod.variant_crafting_tables.entities;

import kittehmod.variant_crafting_tables.blocks.VCTBlocks;
import kittehmod.variant_crafting_tables.blocks.VCTCraftingTableBlock;
import kittehmod.variant_crafting_tables.container.MinecartWorkbenchContainer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.item.minecart.ContainerMinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

public class CraftingTableMinecartEntity extends ContainerMinecartEntity implements IInventory, INamedContainerProvider
{
	private static final DataParameter<Integer> DATA_ID_TYPE = EntityDataManager.defineId(CraftingTableMinecartEntity.class, DataSerializers.INT);

	public CraftingTableMinecartEntity(EntityType<? extends CraftingTableMinecartEntity> workbenchCart, World world) {
		super(workbenchCart, world);
	}

	public CraftingTableMinecartEntity(World worldIn, double x, double y, double z) {
		super(getEntitySubtype(), x, y, z, worldIn);
	}

	public ActionResultType interact(PlayerEntity player, Hand hand) {
		ActionResultType ret = super.interact(player, hand);
		if (ret.consumesAction())
			return ret;
		player.openMenu(this);
		if (!player.level.isClientSide) {
			return ActionResultType.CONSUME;
		} else {
			return ActionResultType.SUCCESS;
		}
	}

	@Override
	public ITextComponent getName() {
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

	public Container createMenu(int cid, PlayerInventory playerInventoryIn) {
		return new MinecartWorkbenchContainer(cid, playerInventoryIn, IWorldPosCallable.create(this.level, this.blockPosition()), this);
	}

	@Override
	public Type getMinecartType() {
		return AbstractMinecartEntity.Type.CHEST; // Arbitrarily set but its only purpose is to make the errors shut up.
	}

	@Override
    public ItemStack getCartItem() {
		return new ItemStack(this.getCraftingTableType().getCartItem());
    }
	
	@Override
	public int getContainerSize() {
		return 9;
	}

	public IPacket<?> getAddEntityPacket() {
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

	protected void addAdditionalSaveData(CompoundNBT compound) {
		compound.putString("Type", this.getCraftingTableType().getCraftingTable().getRegistryName().toString());
	}

	protected void readAdditionalSaveData(CompoundNBT compound) {
		if (compound.contains("Type", 8)) {
			this.setCraftingTableType(CraftingTableMinecartEntity.CraftingTableType.byName(compound.getString("Type")));
		}
	}
	
	public CraftingTableMinecartEntity.CraftingTableType getCraftingTableType() {
		return CraftingTableMinecartEntity.CraftingTableType.byId(this.entityData.get(DATA_ID_TYPE));
	}

	public void setCraftingTableType(CraftingTableType type) {
		this.entityData.set(DATA_ID_TYPE, type.ordinal());
	}

	private static EntityType<CraftingTableMinecartEntity> getEntitySubtype() {
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
		// Team Abnormals
		ASPEN(VCTBlocks.ASPEN_CRAFTING_TABLE.get()),
		GRIMWOOD(VCTBlocks.GRIMWOOD_CRAFTING_TABLE.get()),
		KOUSA(VCTBlocks.KOUSA_CRAFTING_TABLE.get()),
		MORADO(VCTBlocks.MORADO_CRAFTING_TABLE.get()),
		ROSEWOOD(VCTBlocks.ROSEWOOD_CRAFTING_TABLE.get()),
		YUCCA(VCTBlocks.YUCCA_CRAFTING_TABLE.get()),
		BAMBOO(VCTBlocks.BAMBOO_CRAFTING_TABLE.get()),
		MAPLE(VCTBlocks.MAPLE_CRAFTING_TABLE.get()),
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
		// Miscellaneous
		AZURE(VCTBlocks.AZURE_CRAFTING_TABLE.get()),
		FAIRY_RING_MUSHROOM(VCTBlocks.FAIRY_RING_MUSHROOM_CRAFTING_TABLE.get()),
		PETRIFIED(VCTBlocks.PETRIFIED_CRAFTING_TABLE.get()),
		MANGROVE(VCTBlocks.MANGROVE_CRAFTING_TABLE.get());

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

		public static CraftingTableMinecartEntity.CraftingTableType byId(int id) {
			CraftingTableMinecartEntity.CraftingTableType[] acraftingtable$type = values();
			if (id < 0 || id >= acraftingtable$type.length) {
				id = 0;
			}
			return acraftingtable$type[id];
		}
		
		public static CraftingTableMinecartEntity.CraftingTableType byName(String name) {
			CraftingTableMinecartEntity.CraftingTableType[] acraftingtable$type = values();

			for(int i = 0; i < acraftingtable$type.length; ++i) {
				if (acraftingtable$type[i].getName().equalsIgnoreCase(name)) {
					return acraftingtable$type[i];
				}
			}
			return acraftingtable$type[0];
		}
	}
}
