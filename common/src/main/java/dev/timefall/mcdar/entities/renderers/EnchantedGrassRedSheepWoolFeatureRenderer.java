package dev.timefall.mcdar.entities.renderers;

import dev.timefall.mcdar.entities.EnchantedGrassRedSheepEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.client.render.entity.model.SheepWoolEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.Colors;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class EnchantedGrassRedSheepWoolFeatureRenderer extends FeatureRenderer<EnchantedGrassRedSheepEntity, SheepEntityModel<EnchantedGrassRedSheepEntity>> {
    private static final Identifier SKIN = Identifier.of("textures/entity/sheep/sheep_fur.png");
    private final SheepWoolEntityModel<EnchantedGrassRedSheepEntity> model;

    public EnchantedGrassRedSheepWoolFeatureRenderer(FeatureRendererContext<EnchantedGrassRedSheepEntity, SheepEntityModel<EnchantedGrassRedSheepEntity>> context, EntityModelLoader loader) {
        super(context);
        this.model = new SheepWoolEntityModel<>(loader.getModelPart(EntityModelLayers.SHEEP_FUR));

    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, EnchantedGrassRedSheepEntity sheepEntity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        int sheepColor;
        if (sheepEntity.isSheared()) {
            return;
        }
        if (sheepEntity.isInvisible()) {
            MinecraftClient minecraftClient = MinecraftClient.getInstance();
            boolean bl = minecraftClient.hasOutline(sheepEntity);
            if (bl) {
                this.getContextModel().copyStateTo(this.model);
                this.model.animateModel(sheepEntity, limbAngle, limbDistance, tickDelta);
                this.model.setAngles(sheepEntity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
                VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getOutline(SKIN));
                this.model.render(matrixStack, vertexConsumer, light, LivingEntityRenderer.getOverlay(sheepEntity, 0.0f), Colors.RED);
            }
            return;
        }
        if (sheepEntity.hasCustomName() && "Lilly".equals(sheepEntity.getName().getString())) {
            sheepColor = SheepEntity.getRgbColor(DyeColor.PINK);
        } else {
            sheepColor = SheepEntity.getRgbColor(DyeColor.RED);
        }
        render(this.getContextModel(), this.model, SKIN, matrixStack, vertexConsumerProvider, light, sheepEntity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch, sheepColor);
    }
}