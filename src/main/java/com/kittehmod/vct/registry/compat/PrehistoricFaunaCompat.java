package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PrehistoricFaunaCompat 
{
	public static void registerCompat() {
	    VCTRegistry.registerCraftingTable(VCTNames.AGATHOXYLON, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.ARAUCARIA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.BRACHYPHYLLUM, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.GINKGO, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.HEIDIPHYLLUM, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.LIRIODENDRITES, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.METASEQUOIA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.NEOCALAMITES, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.PROTOJUNIPEROXYLON, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.PROTOPICEOXYLON, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.SCHILDERIA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.TROCHODENDROIDES, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.WOODWORTHIA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable(VCTNames.ZAMITES, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	}
}
