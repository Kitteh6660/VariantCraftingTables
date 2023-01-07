package kittehmod.vct;

import kittehmod.vct.blocks.VCTBlocks;
import kittehmod.vct.client.ClientRenderers;
import kittehmod.vct.entities.VCTEntities;
import kittehmod.vct.items.VCTItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(VariantCraftingTablesMod.MOD_ID)
public class VariantCraftingTablesMod
{
	public static final String MOD_ID = "vct";
	
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
    	MinecraftForge.EVENT_BUS.register(new VCTUpdater());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	ClientRenderers.initialize();
    }
}
