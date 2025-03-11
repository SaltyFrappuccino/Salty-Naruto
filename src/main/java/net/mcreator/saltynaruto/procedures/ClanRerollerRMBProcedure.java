package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

public class ClanRerollerRMBProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double clan = 0;
		clan = Mth.nextInt(RandomSource.create(), 1, 10);
		if (clan == 1) {
			{
				String _setval = "Uzumaki";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Uzumaki " + "clan")), false);
		} else if (clan == 2) {
			{
				String _setval = "Senju";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Senju " + "clan")), false);
		} else if (clan == 3) {
			{
				String _setval = "Uchiha";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Uchiha " + "clan")), false);
		} else if (clan == 4) {
			{
				String _setval = "Sarutobi";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Sarutobi " + "clan")), false);
		} else if (clan == 5) {
			{
				String _setval = "Nara";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Nara " + "clan")), false);
		} else if (clan == 6) {
			{
				String _setval = "Aburame";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Aburame " + "clan")), false);
		} else if (clan == 7) {
			{
				String _setval = "Hyuga";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Hyuga " + "clan")), false);
		} else if (clan == 8) {
			{
				String _setval = "Akimichi";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Akimichi " + "clan")), false);
		} else if (clan == 9) {
			{
				String _setval = "Yamanaka";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Yamanaka " + "clan")), false);
		} else if (clan == 10) {
			{
				String _setval = "Gojo";
				entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Clan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Now you in " + "Gojo " + "clan")), false);
		}
	}
}
