package net.domakingo.dmt.block.custom;

import net.domakingo.dmt.entity.custom.SnailEntity;
import net.domakingo.dmt.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;


public class SnailSlimeBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(0,0,0,16,0.1f,16);

    public SnailSlimeBlock(Properties p_49795_) {
        super(p_49795_);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
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

    @Override
    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        if (pUseContext.getItemInHand().is(this.asItem())) {
            if (pUseContext.replacingClickedOnBlock()) {
                return pUseContext.getClickedFace() == Direction.UP;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {

        AABB box = new AABB(pPos.getX() - 1, pPos.getY() - 1, pPos.getZ() - 1, pPos.getX() + 3, pPos.getY() + 3, pPos.getZ() + 3);

        boolean mobPresent = false; // Flag to track if target mobs are found

        // Check for target mobs within the bounding box
        List<SnailEntity> entities = pLevel.getEntitiesOfClass(SnailEntity.class, box);
        if (!entities.isEmpty()) {
            mobPresent = true;
        }

        // Remove the block if no target mobs are present
        if (!mobPresent) {
            pLevel.setBlockAndUpdate(pPos, Blocks.AIR.defaultBlockState());
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);

        double d0 = Math.abs(pEntity.getDeltaMovement().y);
        if (d0 < 0.1D && !pEntity.isSteppingCarefully()) {
            double d1 = 0.4D + d0 * 0.2D;
            pEntity.setDeltaMovement(pEntity.getDeltaMovement().multiply(d1, 1.0D, d1));
        }
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);

        pLevel.playSound(pEntity, pPos, SoundEvents.SLIME_BLOCK_STEP, SoundSource.BLOCKS, 1, 1);
    }
}
