package kittehmod.variant_crafting_tables.items;

import javax.annotation.Nullable;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class VCTCraftingTableItem extends BlockItem
{
	public VCTCraftingTableItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
		if (stack.is(ItemTags.NON_FLAMMABLE_WOOD)) {
			return -1; // Can't be used in furnace.
		}
		else {
			return 300;
		}
		
	}
}
