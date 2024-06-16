package net.domakingo.dmt.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SNAIL_SLIME_SOUP = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120), 0.7f).build();

}
