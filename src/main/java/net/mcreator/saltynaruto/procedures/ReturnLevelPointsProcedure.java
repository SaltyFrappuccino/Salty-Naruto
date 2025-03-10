package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

public class ReturnLevelPointsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "LP: " + Math.round((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).LP);
	}
}
