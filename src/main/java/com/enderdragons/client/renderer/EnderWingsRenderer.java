
package com.enderdragons.client.renderer;

import com.enderdragons.client.model.Modeldragontail;
import com.enderdragons.entity.EnderWingsEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;


public class EnderWingsRenderer extends MobRenderer<EnderWingsEntity, Modeldragontail<EnderWingsEntity>> {
	public EnderWingsRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldragontail(context.bakeLayer(Modeldragontail.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderWingsEntity entity) {
		return new ResourceLocation("die:textures/entities/dragon.png");
	}
}
