
package net.mcreator.saltynaruto.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.saltynaruto.procedures.SetStatTaijutsuLevelProcedure;
import net.mcreator.saltynaruto.procedures.SetStatNinjutsuLevelProcedure;
import net.mcreator.saltynaruto.procedures.SetStatMaxChakraProcedure;
import net.mcreator.saltynaruto.procedures.SetStatLevelProcedure;
import net.mcreator.saltynaruto.procedures.SetStatLPProcedure;
import net.mcreator.saltynaruto.procedures.SetStatJPProcedure;
import net.mcreator.saltynaruto.procedures.SetStatGenjutsuLevelProcedure;
import net.mcreator.saltynaruto.procedures.SetStatChakraPoolProcedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class SnSetStatsCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("sn_SetStats").requires(s -> s.hasPermission(2))
				.then(Commands.argument("target", EntityArgument.players()).then(Commands.literal("ChakraPool").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetStatChakraPoolProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("MaxChakra").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetStatMaxChakraProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("Level").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetStatLevelProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("LP").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetStatLPProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("JP").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetStatJPProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("Ninjutsu").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetStatNinjutsuLevelProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("Taijutsu").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetStatTaijutsuLevelProcedure.execute(arguments);
					return 0;
				}))).then(Commands.literal("Genjutsu").then(Commands.argument("value", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					Level world = arguments.getSource().getUnsidedLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					if (entity == null && world instanceof ServerLevel _servLevel)
						entity = FakePlayerFactory.getMinecraft(_servLevel);
					Direction direction = Direction.DOWN;
					if (entity != null)
						direction = entity.getDirection();

					SetStatGenjutsuLevelProcedure.execute(arguments);
					return 0;
				})))));
	}
}
