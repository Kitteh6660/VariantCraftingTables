package kittehmod.vct.datagen;

import kittehmod.vct.VariantCraftingTablesMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VariantCraftingTablesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class VCTDataGenerators
{
	private VCTDataGenerators() {}
	
	@SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        
        gen.addProvider(true, new VCTBlockStateProvider(gen, existingFileHelper));
        gen.addProvider(true, new VCTItemModelProvider(gen, existingFileHelper));
        gen.addProvider(true, new VCTLootTableProvider(gen));
	}
}
