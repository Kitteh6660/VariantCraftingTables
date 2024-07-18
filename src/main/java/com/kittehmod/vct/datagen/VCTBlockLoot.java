package com.kittehmod.vct.datagen;

import java.util.Set;
import java.util.stream.Stream;

import com.kittehmod.vct.blocks.VCTCraftingTableBlock;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import oshi.util.tuples.Pair;

public class VCTBlockLoot extends BlockLootSubProvider 
{
	public VCTBlockLoot() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected Iterable<Block> getKnownBlocks() {
	   return ForgeRegistries.BLOCKS.getValues().stream().filter((block) -> block instanceof VCTCraftingTableBlock).toList();
	}
	
	@Override
	protected void generate() {
		for (Block block : getKnownBlocks()) {
			super.dropSelf(block);
		}
	}
}
