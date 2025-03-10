
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.saltynaruto.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.saltynaruto.client.renderer.FireballRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SaltyNarutoModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SaltyNarutoModEntities.FIREBALL.get(), FireballRenderer::new);
		event.registerEntityRenderer(SaltyNarutoModEntities.FIRE_GREAT_DESTRUCTION_PROJECTILE.get(), ThrownItemRenderer::new);
	}
}
