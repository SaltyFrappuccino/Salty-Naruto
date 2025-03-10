package net.mcreator.saltynaruto.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ChakraNaturalRegenerationProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool < (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SaltyNarutoModVariables.PlayerVariables())).MaxChakra) {
			{
				double _setval = (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool + 1;
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ChakraPool = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool > (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new SaltyNarutoModVariables.PlayerVariables())).MaxChakra && entity.getPersistentData().getDouble("sn_ChakraNaturalRegen") == 10) {
			entity.getPersistentData().putDouble("sn_ChakraNaturalRegen", 0);
			{
				double _setval = (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool - 1;
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ChakraPool = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			entity.getPersistentData().putDouble("sn_ChakraNaturalRegen", (entity.getPersistentData().getDouble("sn_ChakraNaturalRegen") + 1));
		}
	}
}
