package net.mcreator.saltynaruto.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GreatFlameDestructionJutsuFlowProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("sn_GreatFireDestruction") == true) {
			GreatFlameDestructionJutsuProcedure.execute(world, x, y, z, entity);
			if (entity.getPersistentData().getDouble("sn_GreatFireDestruction_timer") < entity.getPersistentData().getDouble("sn_Charge_2") * 10) {
				entity.getPersistentData().putDouble("sn_GreatFireDestruction_timer", (entity.getPersistentData().getDouble("sn_GreatFireDestruction_timer") + 1));
			} else {
				entity.getPersistentData().putBoolean("sn_GreatFireDestruction", false);
				entity.getPersistentData().putDouble("sn_GreatFireDestruction_timer", 0);
			}
		}
	}
}
