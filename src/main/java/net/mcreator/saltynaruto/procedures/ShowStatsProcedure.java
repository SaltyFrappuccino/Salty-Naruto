package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ShowStatsProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "name")) {
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).MaxChakra)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).PlayerLevel)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).PlayerExperience)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).JP)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).LP)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).Ninjutsu)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).Genjutsu)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).Taijutsu)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).StrengthLevel)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).DurabilityLevel)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).IntelligentLevel)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).SenjutsuLevel)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).IreninjutsuLevel)), false);
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("" + (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).SummoningLevel)), false);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
