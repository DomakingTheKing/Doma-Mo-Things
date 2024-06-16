package net.domakingo.dmt.item.custom;

import net.domakingo.dmt.block.ModBlocks;
import net.domakingo.dmt.item.ModItems;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ScoopItem extends Item {

    public ScoopItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

                BlockState state = pContext.getLevel().getBlockState(positionClicked);

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked, player, state.getBlock());
                    foundBlock = true;
                    pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                            player2 -> player.broadcastBreakEvent(player.getUsedItemHand()));

                }
            }

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModBlocks.SNAIL_SLIME_BLOCK.get());
    }
}