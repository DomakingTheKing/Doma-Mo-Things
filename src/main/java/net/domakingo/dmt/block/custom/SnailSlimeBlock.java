package net.domakingo.dmt.block.custom;

import net.domakingo.dmt.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Component.*;

public class SnailSlimeBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(0,0,0,0.1f,1,16);

    public SnailSlimeBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack a = pPlayer.getItemInHand(pHand);
        if(a.is(ModItems.SCOOP.get())){
            if (!pLevel.isClientSide) {
                Vec3 vec3 = Vec3.atLowerCornerWithOffset(pPos, 0.5D, 1.01D, 0.5D).offsetRandom(pLevel.random, 0.7F);
                ItemEntity itementity = new ItemEntity(pLevel, vec3.x(), vec3.y(), vec3.z(), new ItemStack(ModItems.SNAIL_SLIME.get()));
                itementity.setDefaultPickUpDelay();
                pLevel.addFreshEntity(itementity);
                pLevel.removeBlock(pPos, false);
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
