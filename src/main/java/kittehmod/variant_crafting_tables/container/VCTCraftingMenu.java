package kittehmod.variant_crafting_tables.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.block.Block;

public class VCTCraftingMenu extends CraftingMenu
{
	private final ContainerLevelAccess access;
	private final Block block;
	private final CraftingContainer craftSlots = new CraftingContainer(this, 3, 3);
	private final ResultContainer resultSlots = new ResultContainer();

	public VCTCraftingMenu(int id, Inventory playerInventoryIn, Block blockIn) {
		this(id, playerInventoryIn, ContainerLevelAccess.NULL, blockIn);
	}

	public VCTCraftingMenu(int id, Inventory inv, ContainerLevelAccess p_39358_, Block blockIn) {
		super(id, inv, p_39358_);
		this.access = p_39358_;
		this.block = blockIn;
		this.addSlot(new ResultSlot(inv.player, this.craftSlots, this.resultSlots, 0, 124, 35));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.addSlot(new Slot(this.craftSlots, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}

		for (int k = 0; k < 3; ++k) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlot(new Slot(inv, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		for (int l = 0; l < 9; ++l) {
			this.addSlot(new Slot(inv, l, 8 + l * 18, 142));
		}
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	@Override
	public boolean stillValid(Player playerIn) {
		return stillValid(this.access, playerIn, block);
	}

}