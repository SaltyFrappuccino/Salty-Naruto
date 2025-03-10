package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

public class ChakraOverlayReturnChakraTextProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "\u00A7b\u00A7lChakra Pool: \u00A7r\u00A7f" + Math.round((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool)
				+ "\u00A7r\u00A7f | \u00A7r\u00A73" + Math.round((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).MaxChakra);
	}
}
