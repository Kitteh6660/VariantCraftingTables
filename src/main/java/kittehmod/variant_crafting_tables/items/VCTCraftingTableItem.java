package kittehmod.variant_crafting_tables.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class VCTCraftingTableItem extends BlockItem
{
	public VCTCraftingTableItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public int getBurnTime(ItemStack stack) {
		if (stack.getItem() == VCTItems.CRIMSON_CRAFTING_TABLE.get() || stack.getItem() == VCTItems.WARPED_CRAFTING_TABLE.get() || stack.getItem() == VCTItems.BOP_HELLBARK_CRAFTING_TABLE.get()) {
			return -1; // Can't be used in furnace.
		}
		else {
			return 300;
		}
		
	}
}
