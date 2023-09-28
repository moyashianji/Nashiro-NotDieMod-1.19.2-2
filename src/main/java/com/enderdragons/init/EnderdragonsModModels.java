
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.enderdragons.init;

import com.enderdragons.client.model.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;



@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EnderdragonsModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeldragontail.LAYER_LOCATION, Modeldragontail::createBodyLayer);
		event.registerLayerDefinition(ModeldragonConverted.LAYER_LOCATION, ModeldragonConverted::createBodyLayer);
		event.registerLayerDefinition(Modeldragonwings.LAYER_LOCATION, Modeldragonwings::createBodyLayer);
		event.registerLayerDefinition(Modeldragon.LAYER_LOCATION, Modeldragon::createBodyLayer);
		event.registerLayerDefinition(Modeldragontailshontou.LAYER_LOCATION, Modeldragontailshontou::createBodyLayer);
	}
}
