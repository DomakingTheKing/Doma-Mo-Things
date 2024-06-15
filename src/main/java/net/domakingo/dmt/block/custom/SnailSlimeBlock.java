package net.domakingo.dmt.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SnailSlimeBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(0,0,0,0.1f,1,16);

    public SnailSlimeBlock(Properties p_49795_) {
        super(p_49795_);
    }
}
