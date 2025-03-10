package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

public class ToggleSharinganProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).sharingan == true) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("1"), false);
			{
				boolean _setval = false;
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("2"), false);
			{
				boolean _setval = true;
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sharingan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
