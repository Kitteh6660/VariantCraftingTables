package kittehmod.variant_crafting_tables.blocks;

import kittehmod.variant_crafting_tables.container.VCTWorkbenchContainer;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class VCTCraftingTableBlock extends CraftingTableBlock
{
	public static final ITextComponent TITLE = new TranslationTextComponent("container.crafting");
	
	public VCTCraftingTableBlock(Properties properties) {
		super(properties);
	}
	
    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
    	if (worldIn.isClientSide) {
    		return ActionResultType.SUCCESS;
    	} else {
    		player.openMenu(state.getMenuProvider(worldIn, pos));
    		player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
    		return ActionResultType.CONSUME;
    	}
    }
    
    @Override
    public INamedContainerProvider getMenuProvider(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, player) -> {
           return new VCTWorkbenchContainer(id, inventory, IWorldPosCallable.create(worldIn, pos), this.getBlock());
        }, TITLE);
    }
    
    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
    	if (this.material == Material.NETHER_WOOD) {
    		return -1; // Can't burn.
    	}
    	else {
    		return 20;
    	}
    }
    
    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
    	if (this.material == Material.NETHER_WOOD) {
    		return -1; // Can't catch fire.
    	}
    	else {
    		return 5;
    	}
    }
}
