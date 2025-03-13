package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.saltynaruto.init.SaltyNarutoModItems;

public class StopJutsuChargeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double maxCharge = 0;
		double chargeCost = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SaltyNarutoModItems.FIRE_RELEASE.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sn_currentJutsu") == 1) {
				FireballJutsuProcedure.execute(entity);
				entity.getPersistentData().putBoolean("sn_isCharging", false);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sn_currentJutsu") == 2) {
				GreatFlameDestructionJutsuFlowProcedure.execute(world, x, y, z, entity);
				entity.getPersistentData().putBoolean("sn_isCharging", false);
				entity.getPersistentData().putBoolean("sn_GreatFireDestruction", true);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sn_currentJutsu") == 3) {
				HidingInAshAndDustJutsuProcedure.execute(world, x, y, z, entity);
				entity.getPersistentData().putBoolean("sn_isCharging", false);
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sn_currentJutsu") == 4) {
				GreatFireAnnihilationJutsuProcedure.execute(world, x, y, z, entity);
				entity.getPersistentData().putBoolean("sn_isCharging", false);
			}
		}
	}
}
