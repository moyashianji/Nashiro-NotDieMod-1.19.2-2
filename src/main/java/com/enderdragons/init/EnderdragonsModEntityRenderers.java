
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.enderdragons.init;

import com.enderdragons.client.renderer.EnderWingsRenderer;
import com.enderdragons.client.renderer.EnderbodyRenderer;
import com.enderdragons.client.renderer.EndertailsRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;



@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnderdragonsModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EnderdragonsModEntities.ENDERBODY.get(), EnderbodyRenderer::new);
		event.registerEntityRenderer(EnderdragonsModEntities.ENDER_WINGS.get(), EnderWingsRenderer::new);
		event.registerEntityRenderer(EnderdragonsModEntities.ENDERTAILS.get(), EndertailsRenderer::new);
	}
}
