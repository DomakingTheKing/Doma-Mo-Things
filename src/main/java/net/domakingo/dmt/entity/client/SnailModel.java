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
        CoreGeoBone leftEye = getAnimationProcessor().getBone("LeftBall");
        CoreGeoBone rightEye = getAnimationProcessor().getBone("RightBall");

        if (leftEye != null && rightEye != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            float baseRotY = entityData.netHeadYaw() * Mth.DEG_TO_RAD;
            float baseRotX = entityData.headPitch() * Mth.DEG_TO_RAD;

            // caps
            float MAX_ROT_UP = 55.0f * Mth.DEG_TO_RAD;
            float MAX_ROT_DOWN = 55.0f * Mth.DEG_TO_RAD;
            float MAX_ROT_X = 15.0f * Mth.DEG_TO_RAD;

            float clampedRotY = Math.max(-MAX_ROT_DOWN, Math.min(MAX_ROT_UP, baseRotY));
            float clampedRotX = Math.max(-MAX_ROT_X, Math.min(MAX_ROT_X, baseRotX));

            // Apply the same clamped rotation to both eyes
            leftEye.setRotY(clampedRotY);
            leftEye.setRotX(clampedRotX);

            rightEye.setRotY(clampedRotY);
            rightEye.setRotX(clampedRotX);
        }
    }
}
