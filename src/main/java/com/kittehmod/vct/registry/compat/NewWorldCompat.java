package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class NewWorldCompat 
{
	public static void registerCompat() {
		VCTRegistry.registerCraftingTable("fir_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	}
}
