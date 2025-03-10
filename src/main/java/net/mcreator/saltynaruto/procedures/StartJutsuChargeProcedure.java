package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.Entity;

public class StartJutsuChargeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double maxCharge = 0;
		double chargeCost = 0;
		entity.getPersistentData().putBoolean("sn_isCharging", true);
		entity.getPersistentData().putDouble("sn_Charge_1", 0);
		entity.getPersistentData().putDouble("sn_Charge_2", 0);
	}
}
