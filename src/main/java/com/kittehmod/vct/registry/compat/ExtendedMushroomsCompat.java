package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class ExtendedMushroomsCompat 
{
	public static void registerCompat() {
	 	VCTRegistry.registerCraftingTable(VCTNames.MUSHROOM, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).noOcclusion());
	 	VCTRegistry.registerCraftingTable(VCTNames.GLOWSHROOM, Block.Properties.of().lightLevel((ll) -> { return 11;}).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	 	VCTRegistry.registerCraftingTable(VCTNames.HONEY_FUNGUS, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).noOcclusion());
	 	VCTRegistry.registerCraftingTable(VCTNames.POISONOUS_MUSHROOM, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).noOcclusion());
	}
}
