package kittehmod.vct.datagen;

import java.util.List;

import kittehmod.vct.blocks.VCTBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class VCTBlockLoot extends BlockLoot
{
	@Override
	protected Iterable<Block> getKnownBlocks() {
		List<Block> blocks = VCTBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
		//LOGGER.info(logMarker, "generating loot tables for {} blocks...", blocks.size());
		return blocks;
	}
	
	@Override
	protected void addTables() {
		for (Block block : getKnownBlocks()) {
			add(block, createSingleItemTable(block));
		}
	}
}
