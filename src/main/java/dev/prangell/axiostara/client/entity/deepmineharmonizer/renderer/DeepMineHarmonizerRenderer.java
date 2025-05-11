package dev.prangell.axiostara.client.entity.deepmineharmonizer.renderer;

import dev.prangell.axiostara.Axiostara;
import dev.prangell.axiostara.client.entity.deepmineharmonizer.model.DeepMineHarmonizerModel;
import dev.prangell.axiostara.entity.pulse.DeepMineHarmonizerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DeepMineHarmonizerRenderer extends GeoEntityRenderer<DeepMineHarmonizerEntity> {
    public DeepMineHarmonizerRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new DeepMineHarmonizerModel());
    }

    @Override
    public Identifier getTextureLocation(DeepMineHarmonizerEntity animatable) {
        return new Identifier(Axiostara.MOD_ID, "textures/entity/pulse/deep_mine_harmonizer.png");
    }

    @Override
    public void render(DeepMineHarmonizerEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        poseStack.scale(1.5f, 1.5f, 1.5f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
