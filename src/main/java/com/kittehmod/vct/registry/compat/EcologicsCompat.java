package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class EcologicsCompat 
{
	public static void registerCompat() {
	 	VCTRegistry.registerCraftingTable(VCTNames.ECO_AZALEA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	 	VCTRegistry.registerCraftingTable(VCTNames.ECO_FLOWERING_AZALEA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	 	VCTRegistry.registerCraftingTable(VCTNames.ECO_COCONUT, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	 	VCTRegistry.registerCraftingTable(VCTNames.ECO_WALNUT, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	}
}
