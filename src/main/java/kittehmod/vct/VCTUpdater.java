package kittehmod.vct;

import com.google.common.collect.ImmutableList;

import kittehmod.vct.blocks.VCTBlocks;
import kittehmod.vct.items.VCTItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class VCTUpdater
{
	// Update to newer versions.
	@SubscribeEvent
	public void updateMissingMappingsForBlocks(RegistryEvent.MissingMappings<Block> event) {
		ImmutableList<Mapping<Block>> map = event.getMappings("variant_crafting_tables");
		for (RegistryEvent.MissingMappings.Mapping<Block> entry : map) {
			// Update to remap for conversion from Better Azalea to Ecologics.
			if (ModList.get().isLoaded("ecologics")) {
				if (entry.key.getPath().equalsIgnoreCase("ba_azalea_crafting_table")) {
					entry.remap(VCTBlocks.ECO_AZALEA_CRAFTING_TABLE.get());
				}
				if (entry.key.getPath().equalsIgnoreCase("ba_flowering_azalea_crafting_table")) {
					entry.remap(VCTBlocks.ECO_FLOWERING_AZALEA_CRAFTING_TABLE.get());
				}
				if (entry.key.getPath().equalsIgnoreCase("coconut_crafting_table")) {
					entry.remap(VCTBlocks.ECO_COCONUT_CRAFTING_TABLE.get());
				}
			}
			// Update to new mod ID.
			if (ForgeRegistries.BLOCKS.getValue(new ResourceLocation(VariantCraftingTablesMod.MOD_ID, entry.key.getPath())) != null) {
				entry.remap(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(VariantCraftingTablesMod.MOD_ID, entry.key.getPath())));
			}
		}
	}
	
	@SubscribeEvent
	public void updateMissingMappingsForItems(RegistryEvent.MissingMappings<Item> event) {
		ImmutableList<Mapping<Item>> map = event.getMappings("variant_crafting_tables");
		for (RegistryEvent.MissingMappings.Mapping<Item> entry : map) {
			if (ModList.get().isLoaded("ecologics")) {
				if (entry.key.getPath().equalsIgnoreCase("ba_azalea_crafting_table")) {
					entry.remap(VCTItems.ECO_AZALEA_CRAFTING_TABLE.get());
				}
				if (entry.key.getPath().equalsIgnoreCase("ba_flowering_azalea_crafting_table")) {
					entry.remap(VCTItems.ECO_FLOWERING_AZALEA_CRAFTING_TABLE.get());
				}
				if (entry.key.getPath().equalsIgnoreCase("coconut_crafting_table")) {
					entry.remap(VCTItems.ECO_COCONUT_CRAFTING_TABLE.get());
				}
			}
			if (ForgeRegistries.ITEMS.getValue(new ResourceLocation(VariantCraftingTablesMod.MOD_ID, entry.key.getPath())) != null) {
				entry.remap(ForgeRegistries.ITEMS.getValue(new ResourceLocation(VariantCraftingTablesMod.MOD_ID, entry.key.getPath())));
			}
		}
	}
}
