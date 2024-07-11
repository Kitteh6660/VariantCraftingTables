package com.kittehmod.vct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kittehmod.vct.client.ClientRenderers;
import com.kittehmod.vct.registry.VCTRegistry;
import com.kittehmod.vct.util.CreativeTabHelper;
import com.kittehmod.vct.util.FurnaceFuelHelper;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(VariantCraftingTablesMod.MOD_ID)
public class VariantCraftingTablesMod
{
	public static final String MOD_ID = "vct";
	
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
    public VariantCraftingTablesMod() {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.register(VCTRegistry.class);
    	bus.register(CreativeTabHelper.class);
		bus.addListener(this::setupCommon);
    	if (FMLEnvironment.dist == Dist.CLIENT) {
    		bus.addListener(this::setupClient);
    	}
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
    	MinecraftForge.EVENT_BUS.register(FurnaceFuelHelper.class);
    }
    
    private void setupClient(final FMLClientSetupEvent event) {
    	ClientRenderers.initialize();
    }
}
