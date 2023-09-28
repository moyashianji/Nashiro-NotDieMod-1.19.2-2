
package com.enderdragons.client.renderer;

import com.enderdragons.client.model.Modeldragontailshontou;
import com.enderdragons.entity.EnderbodyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;


public class EnderbodyRenderer extends MobRenderer<EnderbodyEntity, Modeldragontailshontou<EnderbodyEntity>> {
	public EnderbodyRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldragontailshontou(context.bakeLayer(Modeldragontailshontou.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(EnderbodyEntity entity) {
		return new ResourceLocation("die:textures/entities/dragon.png");
	}
}
