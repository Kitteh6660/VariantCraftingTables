package kittehmod.variant_crafting_tables.blocks;

import kittehmod.variant_crafting_tables.container.VCTCraftingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public class VCTCraftingTableBlock extends CraftingTableBlock
{
	public static final Component TITLE = new TranslatableComponent("container.crafting");
	
	public VCTCraftingTableBlock(Properties properties) {
		super(properties);
	}
	
    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit)
    {
    	if (worldIn.isClientSide) {
    		return InteractionResult.SUCCESS;
    	} else {
    		player.openMenu(state.getMenuProvider(worldIn, pos));
    		player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
    		return InteractionResult.CONSUME;
    	}
    }
    
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((id, inventory, player) -> {
           return new VCTCraftingMenu(id, inventory, ContainerLevelAccess.create(level, pos), this);
        }, TITLE);
    }
    
    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
    	if (this.material == Material.WOOD) {
    		return 20;
    	}
    	else {
    		return -1; // Can't burn.
    	}
    }
    
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
    	if (this.material == Material.WOOD) {
    		return 5;
    	}
    	else {
    		return -1; // Can't catch fire.
    	}
    }
}
