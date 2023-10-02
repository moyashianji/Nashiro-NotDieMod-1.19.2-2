
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ukiwa.init;

import com.ukiwa.client.model.Modelukiwahontou;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class UkiwaModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelukiwahontou.LAYER_LOCATION, Modelukiwahontou::createBodyLayer);
	}
}
