package com.kittehmod.vct.registry.compat;

import com.kittehmod.vct.registry.VCTNames;
import com.kittehmod.vct.registry.VCTRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class DarkerDepthsCompat 
{
	public static void registerCompat() {
		VCTRegistry.registerCraftingTable(VCTNames.PETRIFIED, Block.Properties.of().strength(4.0F).sound(SoundType.STONE));
	}
}
