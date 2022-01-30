package kittehmod.variant_crafting_tables;

import kittehmod.variant_crafting_tables.blocks.VCTBlocks;
import kittehmod.variant_crafting_tables.client.ClientRenderers;
import kittehmod.variant_crafting_tables.entities.VCTEntities;
import kittehmod.variant_crafting_tables.items.VCTItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(VariantCraftingTablesMod.MOD_ID)
public class VariantCraftingTablesMod
{
	public static final String MOD_ID = "variant_crafting_tables";
	
    public VariantCraftingTablesMod() {
    	VCTBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	VCTItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    	VCTEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
    	// Nothing here...
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	ClientRenderers.initialize();
    }
}
