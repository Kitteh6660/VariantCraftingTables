package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.fml.ModList;

public class TwilightForestCompat 
{
	public static void registerCompat() {
		VCTRegistry.registerCraftingTable(VCTNames.CANOPY, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.DARKWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.TWILIGHT_MANGROVE, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.MINEWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.SORTINGWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.TIMEWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.TRANSWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		VCTRegistry.registerCraftingTable(VCTNames.TWILIGHT_OAK, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		if (ModList.get().isLoaded("tflostblocks")) {
			VCTRegistry.registerCraftingTable(VCTNames.THORN, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(50.0F, 2000.0F).sound(SoundType.WOOD));
			VCTRegistry.registerCraftingTable(VCTNames.TOWERWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
		}
	}
}
