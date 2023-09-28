
package com.enderdragons.client.renderer;

import com.enderdragons.client.model.ModeldragonConverted;
import com.enderdragons.entity.EndertailsEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;


public class EndertailsRenderer extends MobRenderer<EndertailsEntity, ModeldragonConverted<EndertailsEntity>> {
	public EndertailsRenderer(EntityRendererProvider.Context context) {
		super(context, new ModeldragonConverted(context.bakeLayer(ModeldragonConverted.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EndertailsEntity entity) {
		return new ResourceLocation("enderdragons:textures/entities/dragon.png");
	}
}
