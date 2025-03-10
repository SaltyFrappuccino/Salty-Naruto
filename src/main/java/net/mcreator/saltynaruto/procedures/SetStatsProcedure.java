package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetStatsProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "target")) {
				if ((StringArgumentType.getString(arguments, "stat")).equals("ChakraPool")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraPool = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("MaxChakra")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MaxChakra = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("PlayerLevel")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerLevel = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("PlayerExperience")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerExperience = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("JP")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.JP = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("LP")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LP = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("Ninjutsu")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Ninjutsu = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("Genjutsu")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Genjutsu = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("Taijutsu")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Taijutsu = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("StrengthLevel")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.StrengthLevel = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("DurabilityLevel")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.DurabilityLevel = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				} else if ((StringArgumentType.getString(arguments, "stat")).equals("IntelligentLevel")) {
					{
						double _setval = DoubleArgumentType.getDouble(arguments, "value");
						entityiterator.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.IntelligentLevel = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				}
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
