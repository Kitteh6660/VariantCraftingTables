package kittehmod.variant_crafting_tables.items;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import kittehmod.variant_crafting_tables.VariantCraftingTablesMod;
import kittehmod.variant_crafting_tables.blocks.VCTBlocks;
import kittehmod.variant_crafting_tables.entities.CraftingTableMinecartEntity.CraftingTableType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VCTItems
{
	private static List<Item> items = new ArrayList<Item>();
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VariantCraftingTablesMod.MOD_ID);
	
	// Vanilla
	public static final RegistryObject<Item> SPRUCE_CRAFTING_TABLE = ITEMS.register("spruce_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.SPRUCE_CRAFTING_TABLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	public static final RegistryObject<Item> BIRCH_CRAFTING_TABLE = ITEMS.register("birch_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BIRCH_CRAFTING_TABLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	public static final RegistryObject<Item> JUNGLE_CRAFTING_TABLE = ITEMS.register("jungle_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.JUNGLE_CRAFTING_TABLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	public static final RegistryObject<Item> ACACIA_CRAFTING_TABLE = ITEMS.register("acacia_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.ACACIA_CRAFTING_TABLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	public static final RegistryObject<Item> DARK_OAK_CRAFTING_TABLE = ITEMS.register("dark_oak_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.DARK_OAK_CRAFTING_TABLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	public static final RegistryObject<Item> CRIMSON_CRAFTING_TABLE = ITEMS.register("crimson_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.CRIMSON_CRAFTING_TABLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	public static final RegistryObject<Item> WARPED_CRAFTING_TABLE = ITEMS.register("warped_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.WARPED_CRAFTING_TABLE.get(), new Item.Properties().tab(ItemGroup.TAB_DECORATIONS)));
	
	public static final RegistryObject<Item> OAK_CRAFTING_TABLE_MINECART = ITEMS.register("oak_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1), CraftingTableType.OAK));
	public static final RegistryObject<Item> SPRUCE_CRAFTING_TABLE_MINECART = ITEMS.register("spruce_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1), CraftingTableType.SPRUCE));
	public static final RegistryObject<Item> BIRCH_CRAFTING_TABLE_MINECART = ITEMS.register("birch_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1), CraftingTableType.BIRCH));
	public static final RegistryObject<Item> JUNGLE_CRAFTING_TABLE_MINECART = ITEMS.register("jungle_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1), CraftingTableType.JUNGLE));
	public static final RegistryObject<Item> ACACIA_CRAFTING_TABLE_MINECART = ITEMS.register("acacia_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1), CraftingTableType.ACACIA));
	public static final RegistryObject<Item> DARK_OAK_CRAFTING_TABLE_MINECART = ITEMS.register("dark_oak_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1), CraftingTableType.DARK_OAK));
	public static final RegistryObject<Item> CRIMSON_CRAFTING_TABLE_MINECART = ITEMS.register("crimson_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1), CraftingTableType.CRIMSON));
	public static final RegistryObject<Item> WARPED_CRAFTING_TABLE_MINECART = ITEMS.register("warped_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION).stacksTo(1), CraftingTableType.WARPED));

    /* The big, popular mods */
	// Biomes o' Plenty
	public static final RegistryObject<Item> BOP_CHERRY_CRAFTING_TABLE = ITEMS.register("bop_cherry_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_CHERRY_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_DEAD_CRAFTING_TABLE = ITEMS.register("bop_dead_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_DEAD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_FIR_CRAFTING_TABLE = ITEMS.register("bop_fir_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_FIR_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_HELLBARK_CRAFTING_TABLE = ITEMS.register("bop_hellbark_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_HELLBARK_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_JACARANDA_CRAFTING_TABLE = ITEMS.register("bop_jacaranda_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_JACARANDA_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_MAGIC_CRAFTING_TABLE = ITEMS.register("bop_magic_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_MAGIC_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_MAHOGANY_CRAFTING_TABLE = ITEMS.register("bop_mahogany_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_MAHOGANY_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_PALM_CRAFTING_TABLE = ITEMS.register("bop_palm_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_PALM_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_REDWOOD_CRAFTING_TABLE = ITEMS.register("bop_redwood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_REDWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_UMBRAN_CRAFTING_TABLE = ITEMS.register("bop_umbran_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_UMBRAN_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	public static final RegistryObject<Item> BOP_WILLOW_CRAFTING_TABLE = ITEMS.register("bop_willow_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BOP_WILLOW_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty")))));
	
	public static final RegistryObject<Item> BOP_CHERRY_CRAFTING_TABLE_MINECART = ITEMS.register("bop_cherry_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_CHERRY));
	public static final RegistryObject<Item> BOP_DEAD_CRAFTING_TABLE_MINECART = ITEMS.register("dead_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_DEAD));
	public static final RegistryObject<Item> BOP_FIR_CRAFTING_TABLE_MINECART = ITEMS.register("bop_fir_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_FIR));
	public static final RegistryObject<Item> BOP_HELLBARK_CRAFTING_TABLE_MINECART = ITEMS.register("bop_hellbark_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_HELLBARK));
	public static final RegistryObject<Item> BOP_JACARANDA_CRAFTING_TABLE_MINECART = ITEMS.register("bop_jacaranda_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_JACARANDA));
	public static final RegistryObject<Item> BOP_MAGIC_CRAFTING_TABLE_MINECART = ITEMS.register("bop_magic_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_MAGIC));
	public static final RegistryObject<Item> BOP_MAHOGANY_CRAFTING_TABLE_MINECART = ITEMS.register("bop_mahogany_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_MAHOGANY));
	public static final RegistryObject<Item> BOP_PALM_CRAFTING_TABLE_MINECART = ITEMS.register("bop_palm_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_PALM));
	public static final RegistryObject<Item> BOP_REDWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("bop_redwood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_REDWOOD));
	public static final RegistryObject<Item> BOP_UMBRAN_CRAFTING_TABLE_MINECART = ITEMS.register("bop_umbran_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_UMBRAN));
	public static final RegistryObject<Item> BOP_WILLOW_CRAFTING_TABLE_MINECART = ITEMS.register("bop_willow_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("biomesoplenty", getTabWithMatchingName("biomesoplenty"))).stacksTo(1), CraftingTableType.BOP_WILLOW));
	
	// Twilight Forest
	public static final RegistryObject<Item> CANOPY_CRAFTING_TABLE = ITEMS.register("canopy_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.CANOPY_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest")))));
	public static final RegistryObject<Item> DARKWOOD_CRAFTING_TABLE = ITEMS.register("darkwood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.DARKWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest")))));
	public static final RegistryObject<Item> MANGROVE_CRAFTING_TABLE = ITEMS.register("mangrove_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.MANGROVE_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest")))));
	public static final RegistryObject<Item> MINEWOOD_CRAFTING_TABLE = ITEMS.register("minewood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.MINEWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest")))));
	public static final RegistryObject<Item> SORTINGWOOD_CRAFTING_TABLE = ITEMS.register("sortingwood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.SORTINGWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest")))));
	public static final RegistryObject<Item> TIMEWOOD_CRAFTING_TABLE = ITEMS.register("timewood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.TIMEWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest")))));
	public static final RegistryObject<Item> TRANSWOOD_CRAFTING_TABLE = ITEMS.register("transwood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.TRANSWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest")))));
	public static final RegistryObject<Item> TWILIGHT_OAK_CRAFTING_TABLE = ITEMS.register("twilight_oak_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.TWILIGHT_OAK_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest")))));

	public static final RegistryObject<Item> CANOPY_CRAFTING_TABLE_MINECART = ITEMS.register("canopy_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest"))).stacksTo(1), CraftingTableType.CANOPY));
	public static final RegistryObject<Item> DARKWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("darkwood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest"))).stacksTo(1), CraftingTableType.DARKWOOD));
	public static final RegistryObject<Item> MANGROVE_CRAFTING_TABLE_MINECART = ITEMS.register("mangrove_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest"))).stacksTo(1), CraftingTableType.MANGROVE));
	public static final RegistryObject<Item> MINEWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("minewood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest"))).stacksTo(1), CraftingTableType.MINEWOOD));
	public static final RegistryObject<Item> SORTINGWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("sortingwood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest"))).stacksTo(1), CraftingTableType.SORTINGWOOD));
	public static final RegistryObject<Item> TIMEWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("timewood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest"))).stacksTo(1), CraftingTableType.TIMEWOOD));
	public static final RegistryObject<Item> TRANSWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("transwood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest"))).stacksTo(1), CraftingTableType.TRANSWOOD));
	public static final RegistryObject<Item> TWILIGHT_OAK_CRAFTING_TABLE_MINECART = ITEMS.register("twilight_oak_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("twilightforest", getTabWithMatchingName("twilightforest"))).stacksTo(1), CraftingTableType.TWILIGHT_OAK));

	/* Abnormals Mods */
	// Atmospheric
	public static final RegistryObject<Item> ASPEN_CRAFTING_TABLE = ITEMS.register("aspen_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.ASPEN_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> GRIMWOOD_CRAFTING_TABLE = ITEMS.register("grimwood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.GRIMWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> KOUSA_CRAFTING_TABLE = ITEMS.register("kousa_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.KOUSA_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> MORADO_CRAFTING_TABLE = ITEMS.register("morado_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.MORADO_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> ROSEWOOD_CRAFTING_TABLE = ITEMS.register("rosewood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.ROSEWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> YUCCA_CRAFTING_TABLE = ITEMS.register("yucca_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.YUCCA_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> ASPEN_CRAFTING_TABLE_MINECART = ITEMS.register("aspen_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.ASPEN));
	public static final RegistryObject<Item> GRIMWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("grimwood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.GRIMWOOD));
	public static final RegistryObject<Item> KOUSA_CRAFTING_TABLE_MINECART = ITEMS.register("kousa_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.KOUSA));
	public static final RegistryObject<Item> MORADO_CRAFTING_TABLE_MINECART = ITEMS.register("morado_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.MORADO));
	public static final RegistryObject<Item> ROSEWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("rosewood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.ROSEWOOD));
	public static final RegistryObject<Item> YUCCA_CRAFTING_TABLE_MINECART = ITEMS.register("yucca_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("atmospheric", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.YUCCA));
	
	// Autumnity
	public static final RegistryObject<Item> MAPLE_CRAFTING_TABLE = ITEMS.register("maple_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.MAPLE_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("autumnity", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> MAPLE_CRAFTING_TABLE_MINECART = ITEMS.register("maple_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("autumnity", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.MAPLE));

	// Bamboo Blocks
	public static final RegistryObject<Item> BAMBOO_CRAFTING_TABLE = ITEMS.register("bamboo_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BAMBOO_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("bamboo_blocks", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> BAMBOO_CRAFTING_TABLE_MINECART = ITEMS.register("bamboo_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("bamboo_blocks", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.BAMBOO));

	// Endergetic Expansion
	public static final RegistryObject<Item> POISE_CRAFTING_TABLE = ITEMS.register("poise_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.POISE_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("endergetic", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> POISE_CRAFTING_TABLE_MINECART = ITEMS.register("poise_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("endergetic", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.POISE));
	
	// Environmental
	public static final RegistryObject<Item> CHERRY_CRAFTING_TABLE = ITEMS.register("cherry_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.CHERRY_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("environmental", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> WILLOW_CRAFTING_TABLE = ITEMS.register("willow_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.WILLOW_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("environmental", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> WISTERIA_CRAFTING_TABLE = ITEMS.register("wisteria_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.WISTERIA_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("environmental", ItemGroup.TAB_DECORATIONS))));
	
	public static final RegistryObject<Item> CHERRY_CRAFTING_TABLE_MINECART = ITEMS.register("cherry_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("environmental", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.CHERRY));
	public static final RegistryObject<Item> WILLOW_CRAFTING_TABLE_MINECART = ITEMS.register("willow_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("environmental", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.WILLOW));
	public static final RegistryObject<Item> WISTERIA_CRAFTING_TABLE_MINECART = ITEMS.register("wisteria_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("environmental", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.WISTERIA));
	
	// Upgrade Aquatic
	public static final RegistryObject<Item> DRIFTWOOD_CRAFTING_TABLE = ITEMS.register("driftwood_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.DRIFTWOOD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("upgrade_aquatic", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> RIVER_CRAFTING_TABLE = ITEMS.register("river_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.RIVER_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("upgrade_aquatic", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> DRIFTWOOD_CRAFTING_TABLE_MINECART = ITEMS.register("driftwood_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("upgrade_aquatic", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.DRIFTWOOD));
	public static final RegistryObject<Item> RIVER_CRAFTING_TABLE_MINECART = ITEMS.register("river_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("upgrade_aquatic", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.RIVER));
	
	/* Team Aurora Mods */
	// Abundance
	public static final RegistryObject<Item> JACARANDA_CRAFTING_TABLE = ITEMS.register("jacaranda_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.JACARANDA_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("abundance", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> REDBUD_CRAFTING_TABLE = ITEMS.register("redbud_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.REDBUD_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("abundance", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> JACARANDA_CRAFTING_TABLE_MINECART = ITEMS.register("jacaranda_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("abundance", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.JACARANDA));
	public static final RegistryObject<Item> REDBUD_CRAFTING_TABLE_MINECART = ITEMS.register("redbud_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("abundance", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.REDBUD));
	
	// Bayou Blues
	public static final RegistryObject<Item> CYPRESS_CRAFTING_TABLE = ITEMS.register("cypress_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.CYPRESS_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("bayou_blues", ItemGroup.TAB_DECORATIONS))));
	
	public static final RegistryObject<Item> CYPRESS_CRAFTING_TABLE_MINECART = ITEMS.register("cypress_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("bayou_blues", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.CYPRESS));
	
	// Enhanced Mushrooms
	public static final RegistryObject<Item> BROWN_MUSHROOM_CRAFTING_TABLE = ITEMS.register("brown_mushroom_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.BROWN_MUSHROOM_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("enhanced_mushrooms", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> RED_MUSHROOM_CRAFTING_TABLE = ITEMS.register("red_mushroom_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.RED_MUSHROOM_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("enhanced_mushrooms", ItemGroup.TAB_DECORATIONS))));
	public static final RegistryObject<Item> GLOWSHROOM_CRAFTING_TABLE = ITEMS.register("glowshroom_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.GLOWSHROOM_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("enhanced_mushrooms", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> BROWN_MUSHROOM_CRAFTING_TABLE_MINECART = ITEMS.register("brown_mushroom_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("enhanced_mushrooms", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.BROWN_MUSHROOM));
	public static final RegistryObject<Item> RED_MUSHROOM_CRAFTING_TABLE_MINECART = ITEMS.register("red_mushroom_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("enhanced_mushrooms", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.RED_MUSHROOM));
	public static final RegistryObject<Item> GLOWSHROOM_CRAFTING_TABLE_MINECART = ITEMS.register("glowshroom_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("enhanced_mushrooms", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.GLOWSHROOM));
	
	/* Miscellaneous Mods */
	// Darker Depths
	public static final RegistryObject<Item> PETRIFIED_CRAFTING_TABLE = ITEMS.register("petrified_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.PETRIFIED_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("darkerdepths", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> PETRIFIED_CRAFTING_TABLE_MINECART = ITEMS.register("petrified_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("darkerdepths", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.PETRIFIED));

	// Habitat
	public static final RegistryObject<Item> FAIRY_RING_MUSHROOM_CRAFTING_TABLE = ITEMS.register("fairy_ring_mushroom_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.FAIRY_RING_MUSHROOM_CRAFTING_TABLE.get(), new Item.Properties().tab(ModList.get().isLoaded("enhanced_mushrooms") ? conditionallyAddTab("habitat", ItemGroup.TAB_DECORATIONS) : null)));

	public static final RegistryObject<Item> FAIRY_RING_MUSHROOM_CRAFTING_TABLE_MINECART = ITEMS.register("fairy_ring_mushroom_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("enhanced_mushrooms", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.FAIRY_RING_MUSHROOM));
	
	// Outer End
	public static final RegistryObject<Item> AZURE_CRAFTING_TABLE = ITEMS.register("azure_crafting_table", () -> new VCTCraftingTableItem(VCTBlocks.AZURE_CRAFTING_TABLE.get(), new Item.Properties().tab(conditionallyAddTab("outer_end", ItemGroup.TAB_DECORATIONS))));

	public static final RegistryObject<Item> AZURE_CRAFTING_TABLE_MINECART = ITEMS.register("azure_crafting_table_minecart", () -> new CraftingTableMinecartItem(new Item.Properties().tab(conditionallyAddTab("outer_end", ItemGroup.TAB_TRANSPORTATION)).stacksTo(1), CraftingTableType.AZURE));
	
	@Nullable
    private static ItemGroup conditionallyAddTab(String modid, ItemGroup tab) {
    	if (ModList.get().isLoaded(modid)) {
    		return tab;
    	}
    	else {
    		return null;
    	}
    }
    
    private static ItemGroup getTabWithMatchingName(String tabName) {
    	ItemGroup tab = null;
    	for (ItemGroup tempTab : ItemGroup.TABS) {
    		TranslationTextComponent tabComp = (TranslationTextComponent) tempTab.getDisplayName();
    		if (tabComp.getKey().equalsIgnoreCase("itemGroup." + tabName)) {
    			tab = tempTab;
    			break;
    		}
    	}
    	return tab;
    }
    
    @OnlyIn(Dist.CLIENT)
    public static void sortCraftingTablesInTab() {
    	
    }
    
	@EventBusSubscriber(modid = VariantCraftingTablesMod.MOD_ID)
	public static class RegistrationHandler 
	{
	    @SubscribeEvent
	    public static void registerItems(final RegistryEvent.Register<Item> event) {
	    	event.getRegistry().registerAll();
	    }
	}
}
