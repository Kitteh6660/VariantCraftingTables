package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PrehistoricFaunaCompat 
{
	public static void registerCompat() {
	    VCTRegistry.registerCraftingTable("araucaria_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable("heidiphyllum_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable("liriodendrites_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable("metasequoia_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable("protojuniperoxylon_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable("protopiceoxylon_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    VCTRegistry.registerCraftingTable("zamites_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	}
}
