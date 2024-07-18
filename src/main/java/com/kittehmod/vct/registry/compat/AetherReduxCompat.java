package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class AetherReduxCompat 
{
	public static void registerCompat() {
		VCTRegistry.registerCraftingTable(VCTNames.BLIGHTWILLOW, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.CLOUDCAP, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.CRYSTAL, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.FIELDSPROUT, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.GLACIA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.JELLYSHROOM, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	}
}
