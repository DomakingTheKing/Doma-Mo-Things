package net.domakingo.dmt.entity.client;

import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.entity.custom.SnailEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SnailModel extends GeoModel<SnailEntity> {

    @Override
    public ResourceLocation getModelResource(SnailEntity snailEntity) {
        return new ResourceLocation(MoThingsMod.MOD_ID, "geo/snail.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SnailEntity snailEntity) {
        return new ResourceLocation(MoThingsMod.MOD_ID, "textures/entity/snail.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SnailEntity snailEntity) {
        return new ResourceLocation(MoThingsMod.MOD_ID, "animations/snail.animation.json");
    }

    @Override
    public void setCustomAnimations(SnailEntity animatable, long instanceId, AnimationState<SnailEntity> animationState) {
        CoreGeoBone eyes = getAnimationProcessor().getBone("Eyes");

        if (eyes != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            eyes.setRotX((entityData.headPitch() * Mth.DEG_TO_RAD));
            eyes.setRotY((entityData.netHeadYaw() * Mth.DEG_TO_RAD));
        }
    }
}
