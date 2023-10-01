
package com.cactus.renderer;

import com.cactus.entity.CactusEntity;
import com.cactus.model.CactusModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import static com.cactus.NearCactusEvent.aaa;


public class DdddRenderer extends MobRenderer<CactusEntity, CactusModel<CactusEntity>> {
	public DdddRenderer(EntityRendererProvider.Context context) {
		super(context, new CactusModel(context.bakeLayer(CactusModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CactusEntity entity) {
		return new ResourceLocation("die:textures/entities/sss.png");
	}
	protected void scale(CactusEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {

		float f = 10.0F;
		matrixStackIn.scale(aaa,1.0F,aaa);//全部０．８売
	}
}
