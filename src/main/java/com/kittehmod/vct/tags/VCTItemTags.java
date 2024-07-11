package com.kittehmod.vct.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class VCTItemTags
{
	public static final TagKey<Item> CRAFTING_TABLES = ItemTags.create(new ResourceLocation("forge", "workbench"));
}
