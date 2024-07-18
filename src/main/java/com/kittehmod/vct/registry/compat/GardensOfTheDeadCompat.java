package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class GardensOfTheDeadCompat 
{
	public static void registerCompat() {
	 	VCTRegistry.registerCraftingTable(VCTNames.SOULBLIGHT, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.NETHER_WOOD));
	 	VCTRegistry.registerCraftingTable(VCTNames.WHISTLECANE, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.BAMBOO_WOOD));
	}
}
