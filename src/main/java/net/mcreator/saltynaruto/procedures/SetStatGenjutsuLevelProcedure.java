package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetStatGenjutsuLevelProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "target")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "value");
					entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Taijutsu = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
