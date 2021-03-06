package kittehmod.vct.blocks;

import kittehmod.vct.VariantCraftingTablesMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VCTBlocks
{	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VariantCraftingTablesMod.MOD_ID);

	// Vanilla
    public static final RegistryObject<Block> SPRUCE_CRAFTING_TABLE = BLOCKS.register("spruce_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_CRAFTING_TABLE = BLOCKS.register("birch_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> JUNGLE_CRAFTING_TABLE = BLOCKS.register("jungle_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ACACIA_CRAFTING_TABLE = BLOCKS.register("acacia_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DARK_OAK_CRAFTING_TABLE = BLOCKS.register("dark_oak_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MANGROVE_CRAFTING_TABLE = BLOCKS.register("mangrove_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRIMSON_CRAFTING_TABLE = BLOCKS.register("crimson_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WARPED_CRAFTING_TABLE = BLOCKS.register("warped_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.5F).sound(SoundType.WOOD)));

    /* The big, popular mods */
    // Biomes o' Plenty
    public static final RegistryObject<Block> BOP_CHERRY_CRAFTING_TABLE = BLOCKS.register("bop_cherry_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_DEAD_CRAFTING_TABLE = BLOCKS.register("bop_dead_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_FIR_CRAFTING_TABLE = BLOCKS.register("bop_fir_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_HELLBARK_CRAFTING_TABLE = BLOCKS.register("bop_hellbark_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_JACARANDA_CRAFTING_TABLE = BLOCKS.register("bop_jacaranda_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_MAGIC_CRAFTING_TABLE = BLOCKS.register("bop_magic_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_MAHOGANY_CRAFTING_TABLE = BLOCKS.register("bop_mahogany_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_PALM_CRAFTING_TABLE = BLOCKS.register("bop_palm_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_REDWOOD_CRAFTING_TABLE = BLOCKS.register("bop_redwood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_UMBRAN_CRAFTING_TABLE = BLOCKS.register("bop_umbran_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BOP_WILLOW_CRAFTING_TABLE = BLOCKS.register("bop_willow_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

    // Twilight Forest
    public static final RegistryObject<Block> CANOPY_CRAFTING_TABLE = BLOCKS.register("canopy_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> DARKWOOD_CRAFTING_TABLE = BLOCKS.register("darkwood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TWILIGHT_MANGROVE_CRAFTING_TABLE = BLOCKS.register("twilight_mangrove_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> MINEWOOD_CRAFTING_TABLE = BLOCKS.register("minewood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> SORTINGWOOD_CRAFTING_TABLE = BLOCKS.register("sortingwood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TIMEWOOD_CRAFTING_TABLE = BLOCKS.register("timewood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TRANSWOOD_CRAFTING_TABLE = BLOCKS.register("transwood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> TWILIGHT_OAK_CRAFTING_TABLE = BLOCKS.register("twilight_oak_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

	/* Abnormals Mods */
    // Atmospheric
    public static final RegistryObject<Block> ASPEN_CRAFTING_TABLE = BLOCKS.register("aspen_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GRIMWOOD_CRAFTING_TABLE = BLOCKS.register("grimwood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.NETHER_WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> KOUSA_CRAFTING_TABLE = BLOCKS.register("kousa_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> MORADO_CRAFTING_TABLE = BLOCKS.register("morado_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ROSEWOOD_CRAFTING_TABLE = BLOCKS.register("rosewood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> YUCCA_CRAFTING_TABLE = BLOCKS.register("yucca_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    
    // Autumnity
    public static final RegistryObject<Block> MAPLE_CRAFTING_TABLE = BLOCKS.register("maple_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    
    // Bamboo Blocks
    public static final RegistryObject<Block> BAMBOO_CRAFTING_TABLE = BLOCKS.register("bamboo_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    
    // Caverns and Chasms
    public static final RegistryObject<Block> AZALEA_CRAFTING_TABLE = BLOCKS.register("azalea_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    
    // Endergetic Expansion
    public static final RegistryObject<Block> POISE_CRAFTING_TABLE = BLOCKS.register("poise_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    
    // Environmental
    public static final RegistryObject<Block> CHERRY_CRAFTING_TABLE = BLOCKS.register("cherry_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WILLOW_CRAFTING_TABLE = BLOCKS.register("willow_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WISTERIA_CRAFTING_TABLE = BLOCKS.register("wisteria_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

    // Upgrade Aquatic
    public static final RegistryObject<Block> DRIFTWOOD_CRAFTING_TABLE = BLOCKS.register("driftwood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RIVER_CRAFTING_TABLE = BLOCKS.register("river_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

	/* Team Aurora Mods */
    // Abundance
 	public static final RegistryObject<Block> JACARANDA_CRAFTING_TABLE = BLOCKS.register("jacaranda_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> REDBUD_CRAFTING_TABLE = BLOCKS.register("redbud_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    
    // Bayou Blues
 	public static final RegistryObject<Block> CYPRESS_CRAFTING_TABLE = BLOCKS.register("cypress_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

 	// Enhanced Mushrooms
 	public static final RegistryObject<Block> BROWN_MUSHROOM_CRAFTING_TABLE = BLOCKS.register("brown_mushroom_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> RED_MUSHROOM_CRAFTING_TABLE = BLOCKS.register("red_mushroom_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> GLOWSHROOM_CRAFTING_TABLE = BLOCKS.register("glowshroom_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).noOcclusion().lightLevel((ll) -> { return 11; }).strength(2.5F).sound(SoundType.WOOD)));

	/* Miscellaneous Mods */
 	// Architects Palette
  	public static final RegistryObject<Block> TWISTED_CRAFTING_TABLE = BLOCKS.register("twisted_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
  	
 	// Darker Depths
 	public static final RegistryObject<Block> PETRIFIED_CRAFTING_TABLE = BLOCKS.register("petrified_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.STONE).strength(4.0F).sound(SoundType.WOOD)));
    
 	// Ecologics
 	public static final RegistryObject<Block> ECO_AZALEA_CRAFTING_TABLE = BLOCKS.register("eco_azalea_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> ECO_FLOWERING_AZALEA_CRAFTING_TABLE = BLOCKS.register("eco_flowering_azalea_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> ECO_COCONUT_CRAFTING_TABLE = BLOCKS.register("eco_coconut_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> ECO_WALNUT_CRAFTING_TABLE = BLOCKS.register("eco_walnut_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	
 	// Habitat
 	public static final RegistryObject<Block> FAIRY_RING_MUSHROOM_CRAFTING_TABLE = BLOCKS.register("fairy_ring_mushroom_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));

    // Outer End
 	public static final RegistryObject<Block> AZURE_CRAFTING_TABLE = BLOCKS.register("azure_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	
 	// Prehistoric Fauna
    public static final RegistryObject<Block> ARAUCARIA_CRAFTING_TABLE = BLOCKS.register("araucaria_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> HEIDIPHYLLUM_CRAFTING_TABLE = BLOCKS.register("heidiphyllum_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LIRIODENDRITES_CRAFTING_TABLE = BLOCKS.register("liriodendrites_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> METASEQUOIA_CRAFTING_TABLE = BLOCKS.register("metasequoia_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PROTOJUNIPEROXYLON_CRAFTING_TABLE = BLOCKS.register("protojuniperoxylon_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PROTOPICEOXYLON_CRAFTING_TABLE = BLOCKS.register("protopiceoxylon_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ZAMITES_CRAFTING_TABLE = BLOCKS.register("zamites_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	
  	// Quark
 	public static final RegistryObject<Block> QUARK_AZALEA_CRAFTING_TABLE = BLOCKS.register("quark_azalea_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> QUARK_BLOSSOM_CRAFTING_TABLE = BLOCKS.register("quark_blossom_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
    
 	// Undergarden
 	public static final RegistryObject<Block> GRONGLE_CRAFTING_TABLE = BLOCKS.register("grongle_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> SMOGSTEM_CRAFTING_TABLE = BLOCKS.register("smogstem_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
 	public static final RegistryObject<Block> WIGGLEWOOD_CRAFTING_TABLE = BLOCKS.register("wigglewood_crafting_table", () -> new VCTCraftingTableBlock(Block.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD))); 	

    /*@EventBusSubscriber(modid = VariantCraftingTablesMod.MOD_ID)
	public static class RegistrationHandler 
	{
		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name) {
			return setup(entry, new ResourceLocation(VariantCraftingTablesMod.MOD_ID, name));
		}

		public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName) {
			entry.setRegistryName(registryName);
			return entry;
		}
		
	    @SubscribeEvent
	    public static void registerBlocks(final RegistryEvent.Register<Block> event) { 
	    	event.getRegistry().registerAll();
	    }
	    
	    @SubscribeEvent
	    public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
	    	event.getRegistry().registerAll();
	    }
	}*/
    
}
