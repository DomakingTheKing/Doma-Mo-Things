package net.domakingo.dmt.block.custom;

import net.domakingo.dmt.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SnailShellBlock extends Block {

    public static final VoxelShape SHAPE = Block.box(2,0,2,14,12.5f,14);

    public SnailShellBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        Item heldItem = pPlayer.getItemInHand(pHand).getItem();

        if (heldItem == Items.SHEARS) {
            pLevel.removeBlock(pPos, false);

            Block newBlock = ModBlocks.OPENED_SNAIL_SHELL_BLOCK.get();

            if (pLevel.setBlockAndUpdate(pPos, newBlock.defaultBlockState())) {
                pLevel.playSound(pPlayer, pPos, SoundEvents.SNIFFER_EGG_HATCH, SoundSource.BLOCKS);
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.SUCCESS;
    }

}
