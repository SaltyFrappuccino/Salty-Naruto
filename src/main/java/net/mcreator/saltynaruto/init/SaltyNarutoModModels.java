
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.saltynaruto.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.saltynaruto.client.model.ModelFireball;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SaltyNarutoModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelFireball.LAYER_LOCATION, ModelFireball::createBodyLayer);
	}
}
