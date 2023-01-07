package kittehmod.vct;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class VCTTags
{
	public static final TagKey<Block> CRAFTING_TABLES = BlockTags.create(new ResourceLocation("forge", "workbench"));
}
