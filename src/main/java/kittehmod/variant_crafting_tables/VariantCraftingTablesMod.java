package kittehmod.variant_crafting_tables;

import kittehmod.variant_crafting_tables.blocks.VCTBlocks;
import kittehmod.variant_crafting_tables.client.ClientRenderers;
import kittehmod.variant_crafting_tables.crafting.conditions.AbundanceModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.AtmosphericModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.AutumnityModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.BambooBlocksModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.BayouBluesModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.BiomesOPlentyModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.DarkerDepthsModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.EndergeticModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.EnhancedMushroomsModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.EnvironmentalModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.HabitatModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.OuterEndModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.TwilightForestModInstalledCondition;
import kittehmod.variant_crafting_tables.crafting.conditions.UpgradeAquaticModInstalledCondition;
import kittehmod.variant_crafting_tables.entities.VCTEntities;
import kittehmod.variant_crafting_tables.items.VCTItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
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
    	CraftingHelper.register(new BiomesOPlentyModInstalledCondition.Serializer());
    	CraftingHelper.register(new TwilightForestModInstalledCondition.Serializer());
    	
    	CraftingHelper.register(new AtmosphericModInstalledCondition.Serializer());
    	CraftingHelper.register(new AutumnityModInstalledCondition.Serializer());
    	CraftingHelper.register(new BambooBlocksModInstalledCondition.Serializer());
    	CraftingHelper.register(new EndergeticModInstalledCondition.Serializer());
    	CraftingHelper.register(new EnvironmentalModInstalledCondition.Serializer());
    	CraftingHelper.register(new UpgradeAquaticModInstalledCondition.Serializer());
    	
    	CraftingHelper.register(new AbundanceModInstalledCondition.Serializer());
    	CraftingHelper.register(new BayouBluesModInstalledCondition.Serializer());
    	CraftingHelper.register(new EnhancedMushroomsModInstalledCondition.Serializer());
    	
    	CraftingHelper.register(new DarkerDepthsModInstalledCondition.Serializer());
    	CraftingHelper.register(new HabitatModInstalledCondition.Serializer());
    	CraftingHelper.register(new OuterEndModInstalledCondition.Serializer());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	ClientRenderers.initialize();
    }
}
