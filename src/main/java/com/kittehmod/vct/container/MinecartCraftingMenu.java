package com.kittehmod.vct.container;

import net.minecraftforge.common.ForgeMod;

import com.kittehmod.vct.entities.MinecartCraftingTable;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.inventory.ResultContainer;
import net.minecraft.world.inventory.ResultSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.TransientCraftingContainer;

public class MinecartCraftingMenu extends CraftingMenu
{
	private final CraftingContainer craftSlots = new TransientCraftingContainer(this, 3, 3);
	private final ResultContainer resultSlots = new ResultContainer();
	private final MinecartCraftingTable entity;

	public MinecartCraftingMenu(int id, Inventory playerInventoryIn, MinecartCraftingTable entityIn) {
		this(id, playerInventoryIn, ContainerLevelAccess.NULL, entityIn);
	}

	public MinecartCraftingMenu(int id, Inventory playerInventoryIn, ContainerLevelAccess worldPosIn, MinecartCraftingTable entityIn) {
		super(id, playerInventoryIn, worldPosIn);
		this.entity = entityIn;
	}

	/**
	 * Determines whether supplied player can use this container
	 */
	@Override
	public boolean stillValid(Player playerIn) {
		return playerIn.distanceTo(this.entity) <= playerIn.getEntityReach() + 0.5F;
	}
}
