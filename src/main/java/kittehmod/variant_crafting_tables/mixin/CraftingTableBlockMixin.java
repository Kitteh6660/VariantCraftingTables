package kittehmod.variant_crafting_tables.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(CraftingTableBlock.class)
public class CraftingTableBlockMixin
{
	//This Mixin class adds flammability to Oak (Vanilla) Crafting Table.
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
    	return 20;
    }
    
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
    	return 5;
    }
}
