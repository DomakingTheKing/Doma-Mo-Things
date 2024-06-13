package net.domakingo.dmt.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.domakingo.dmt.MoThingsMod;
import net.domakingo.dmt.entity.custom.SnailEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SnailRenderer extends GeoEntityRenderer<SnailEntity> {
    public SnailRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SnailModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SnailEntity animatable) {
        return new ResourceLocation(MoThingsMod.MOD_ID, "textures/entity/snail.png");
    }

    @Override
    public void render(SnailEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(1f, 1f, 1f);
        } else {
            poseStack.scale(2f, 2f, 2f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
