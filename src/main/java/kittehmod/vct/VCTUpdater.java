package kittehmod.vct;

import java.util.List;

import kittehmod.vct.blocks.VCTBlocks;
import kittehmod.vct.items.VCTItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
import net.minecraftforge.registries.MissingMappingsEvent.Mapping;

public class VCTUpdater
{
	// Update to newer versions.
	@SubscribeEvent
	public void updateMissingMappingsForBlocks(MissingMappingsEvent event) {
		List<Mapping<Block>> map = event.getMappings(ForgeRegistries.BLOCKS.getRegistryKey(), VariantCraftingTablesMod.MOD_ID);
		for (Mapping<Block> entry : map) {
			// Update to remap after removal of three crafting tables.
			if (entry.getKey().getPath().equalsIgnoreCase("cerulean_crafting_table")) {
				entry.remap(VCTBlocks.CONGEALED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("cosmic_crafting_table")) {
				entry.remap(VCTBlocks.CONGEALED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("stalk_crafting_table")) {
				entry.remap(VCTBlocks.CONGEALED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("seldge_crafting_table")) {
				entry.remap(VCTBlocks.CONGEALED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("akashic_crafting_table")) {
				entry.remap(VCTBlocks.EDIFIED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("mysterywood_crafting_table")) {
				entry.remap(VCTBlocks.AURUM_CRAFTING_TABLE.get());
			}
		}
	}
	
	@SubscribeEvent
	public void updateMissingMappingsForItems(MissingMappingsEvent event) {
		List<Mapping<Item>> map = event.getMappings(VCTItems.ITEMS.getRegistryKey(), VariantCraftingTablesMod.MOD_ID);
		for (Mapping<Item> entry : map) {
			if (entry.getKey().getPath().equalsIgnoreCase("cerulean_crafting_table")) {
				entry.remap(VCTItems.CONGEALED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("cosmic_crafting_table")) {
				entry.remap(VCTItems.CONGEALED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("stalk_crafting_table")) {
				entry.remap(VCTItems.CONGEALED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("seldge_crafting_table")) {
				entry.remap(VCTItems.CONGEALED_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("mysterywood_crafting_table")) {
				entry.remap(VCTItems.AURUM_CRAFTING_TABLE.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("cerulean_crafting_table_minecart")) {
				entry.remap(VCTItems.CONGEALED_CRAFTING_TABLE_MINECART.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("cosmic_crafting_table_minecart")) {
				entry.remap(VCTItems.CONGEALED_CRAFTING_TABLE_MINECART.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("stalk_crafting_table_minecart")) {
				entry.remap(VCTItems.CONGEALED_CRAFTING_TABLE_MINECART.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("seldge_crafting_table_minecart")) {
				entry.remap(VCTItems.CONGEALED_CRAFTING_TABLE_MINECART.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("akashic_crafting_table_minecart")) {
				entry.remap(VCTItems.EDIFIED_CRAFTING_TABLE_MINECART.get());
			}
			if (entry.getKey().getPath().equalsIgnoreCase("mysterywood_crafting_table_minecart")) {
				entry.remap(VCTItems.AURUM_CRAFTING_TABLE_MINECART.get());
			}
		}
	}
}
