package com.kittehmod.vct.util;

import com.kittehmod.vct.tags.VCTItemTags;

import net.minecraft.tags.ItemTags;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FurnaceFuelHelper 
{
	@SubscribeEvent
	public static void setFurnaceFuelTimes(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().is(VCTItemTags.CRAFTING_TABLES) && !event.getItemStack().is(ItemTags.NON_FLAMMABLE_WOOD)) {
			event.setBurnTime(300);
		}
	}
}
