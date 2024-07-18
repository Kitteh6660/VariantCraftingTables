package com.kittehmod.vct.datagen;

import java.util.List;

import com.kittehmod.vct.VariantCraftingTablesMod;
import com.kittehmod.vct.datagen.VCTBlockLoot;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.data.loot.packs.VanillaLootTableProvider;

@Mod.EventBusSubscriber(modid = VariantCraftingTablesMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class VCTDatagens 
{
	@SubscribeEvent
	public static void initializeDatagens(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
		gen.addProvider(true, new VCTLootTableProvider(output, BuiltInLootTables.all(), List.of(new VCTLootTableProvider.SubProviderEntry(VCTBlockLoot::new, LootContextParamSets.BLOCK))));
	}
}
