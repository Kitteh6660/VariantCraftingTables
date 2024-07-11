package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.fml.ModList;

public class AbnormalsCompat 
{
	public static void registerCompat() {
	    if (ModList.get().isLoaded("atmospheric")) {
	    	VCTRegistry.registerCraftingTable(VCTNames.ASPEN, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.GRIMWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.KOUSA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.LAUREL, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.MORADO, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.ROSEWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.YUCCA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    }
	    if (ModList.get().isLoaded("autumnity")) {
	    	VCTRegistry.registerCraftingTable(VCTNames.MAPLE, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    }
	    if (ModList.get().isLoaded("caverns_and_chasms")) {
	    	VCTRegistry.registerCraftingTable(VCTNames.AZALEA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    }
	    if (ModList.get().isLoaded("endergetic")) {
	    	VCTRegistry.registerCraftingTable(VCTNames.POISE, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    }
	    if (ModList.get().isLoaded("environmental")) {
	    	VCTRegistry.registerCraftingTable(VCTNames.DARK_CHERRY, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.PINE, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.WILLOW, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.WISTERIA, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    }
	    if (ModList.get().isLoaded("upgrade_aquatic")) {
	    	VCTRegistry.registerCraftingTable(VCTNames.DRIFTWOOD, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    	VCTRegistry.registerCraftingTable(VCTNames.RIVER, Block.Properties.of().instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD));
	    }
	}
}
