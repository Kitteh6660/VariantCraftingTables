package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class EnhancedMushroomsCompat 
{
	public static void registerCompat() {
		// VCTRegistry.registerCraftingTable(VCTNames.BROWN_MUSHROOM, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD)); // Legacy
		VCTRegistry.registerCraftingTable(VCTNames.RED_MUSHROOM, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	}
}
