package net.domakingo.dmt.item.custom;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Instrument;
import net.minecraft.world.item.InstrumentItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class HornItem extends InstrumentItem {
    public HornItem(Properties pProperties, TagKey<Instrument> pInstruments) {
        super(pProperties, pInstruments);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pLevel.playSound(pPlayer,pPlayer.getX(),pPlayer.getY(),pPlayer.getZ(), SoundEvents.BAMBOO_BREAK,SoundSource.BLOCKS);
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}

