package kittehmod.variant_crafting_tables.mixin;

import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

@Mixin(CraftingTableBlock.class)
public class CraftingTableBlockMixin
{
	//This Mixin class adds flammability to Oak (Vanilla) Crafting Table.
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
    	return 20;
    }
    
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
    	return 5;
    }
}
