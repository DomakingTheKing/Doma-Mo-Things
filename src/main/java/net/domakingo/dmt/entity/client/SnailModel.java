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
        CoreGeoBone leftEye = getAnimationProcessor().getBone("LeftBall");
        CoreGeoBone rightEye = getAnimationProcessor().getBone("RightBall");

        if (eyes != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            // Calculate base rotations based on head pitch
            float baseRotY = entityData.headPitch() * Mth.DEG_TO_RAD;
            float baseRotX = entityData.headPitch() * Mth.DEG_TO_RAD;

            // Apply capping limits
            float MAX_ROT_UP = 90.0f; // Maximum rotation upwards (in degrees)
            float MAX_ROT_DOWN = 40.0f; // Maximum rotation downwards (in degrees)
            float MAX_ROT_X = 50.0f;    // Maximum rotation left/right (in degrees)

            // Capped rotations for left eye
            float cappedRotY = Math.max(-MAX_ROT_DOWN, Math.min(MAX_ROT_UP, baseRotY));
            float cappedRotX = Math.max(-MAX_ROT_X, Math.min(MAX_ROT_X, baseRotX));

            // Set rotations with capping
            leftEye.setPivotX(1f);
            leftEye.setPivotY(4.375f);
            leftEye.setPivotZ(-6.125f);
            leftEye.setRotY(cappedRotY);
            leftEye.setRotX(cappedRotX);

            rightEye.setPivotX(1f);
            rightEye.setPivotY(4.375f);
            rightEye.setPivotZ(-6.125f);
            rightEye.setRotY(cappedRotY);
            rightEye.setRotX(cappedRotX);
        }
    }
}
