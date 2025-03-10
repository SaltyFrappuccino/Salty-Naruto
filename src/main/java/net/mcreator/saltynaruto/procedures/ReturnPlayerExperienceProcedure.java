package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

public class ReturnPlayerExperienceProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Player Experience: " + Math.round((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).PlayerExperience);
	}
}
