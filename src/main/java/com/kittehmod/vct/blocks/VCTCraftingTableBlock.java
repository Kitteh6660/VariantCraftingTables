package com.kittehmod.vct.blocks;

import com.kittehmod.vct.container.VCTCraftingMenu;
import com.kittehmod.vct.tags.VCTBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class VCTCraftingTableBlock extends CraftingTableBlock
{
	public static final Component TITLE = Component.translatable("container.crafting");
	
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
    	if (this.defaultBlockState().is(VCTBlockTags.CRAFTING_TABLES) && this.soundType != SoundType.NETHER_WOOD) {
    		return 20;
    	}
    	else {
    		return -1; // Can't burn.
    	}
    }
    
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
    	if (this.defaultBlockState().is(VCTBlockTags.CRAFTING_TABLES) && this.soundType != SoundType.NETHER_WOOD) {
    		return 5;
    	}
    	else {
    		return -1; // Can't catch fire.
    	}
    }
}
