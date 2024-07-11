package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class ExtendedMushroomsCompat 
{
	public static void registerCompat() {
	 	VCTRegistry.registerCraftingTable("mushroom_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).noOcclusion());
	 	VCTRegistry.registerCraftingTable("poisonous_mushroom_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).noOcclusion());
	 	VCTRegistry.registerCraftingTable("honey_fungus_crafting_table", Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).noOcclusion());
	 	VCTRegistry.registerCraftingTable("glowshroom_crafting_table", Block.Properties.of().lightLevel((ll) -> { return 11;}).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	}
}
