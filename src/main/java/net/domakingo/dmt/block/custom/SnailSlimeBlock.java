package net.domakingo.dmt.block.custom;

import net.domakingo.dmt.entity.ModEntities;
import net.domakingo.dmt.entity.custom.SnailEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib.animatable.GeoEntity;

import java.util.List;

public class SnailSlimeBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(0,0,0,16,0.1f,16);

    public SnailSlimeBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
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