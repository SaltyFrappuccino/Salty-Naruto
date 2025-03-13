package net.mcreator.saltynaruto.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;
import net.mcreator.saltynaruto.init.SaltyNarutoModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JutsuChargeProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double maxCharge = 0;
		double chargeCost = 0;
		if (entity.getPersistentData().getBoolean("sn_isCharging") == true) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == SaltyNarutoModItems.FIRE_RELEASE.get()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sn_currentJutsu") == 1) {
					maxCharge = 10;
					chargeCost = 1000;
					if (entity.getPersistentData().getDouble("sn_Charge_2") <= maxCharge) {
						entity.getPersistentData().putDouble("sn_Charge_1", (entity.getPersistentData().getDouble("sn_Charge_1") + 1));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Charge: " + Math.round(entity.getPersistentData().getDouble("sn_Charge_2")))), true);
						if (entity.getPersistentData().getDouble("sn_Charge_1") == 10
								&& (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool >= chargeCost) {
							entity.getPersistentData().putDouble("sn_Charge_1", 0);
							entity.getPersistentData().putDouble("sn_Charge_2", (entity.getPersistentData().getDouble("sn_Charge_2") + 1));
							{
								double _setval = (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool - chargeCost;
								entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraPool = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sn_currentJutsu") == 2) {
					maxCharge = 5;
					chargeCost = 1500;
					if (entity.getPersistentData().getDouble("sn_Charge_2") <= maxCharge) {
						entity.getPersistentData().putDouble("sn_Charge_1", (entity.getPersistentData().getDouble("sn_Charge_1") + 1));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Charge: " + Math.round(entity.getPersistentData().getDouble("sn_Charge_2")))), true);
						if (entity.getPersistentData().getDouble("sn_Charge_1") == 10
								&& (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool >= chargeCost) {
							entity.getPersistentData().putDouble("sn_Charge_1", 0);
							entity.getPersistentData().putDouble("sn_Charge_2", (entity.getPersistentData().getDouble("sn_Charge_2") + 1));
							{
								double _setval = (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool - chargeCost;
								entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraPool = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sn_currentJutsu") == 3) {
					maxCharge = 15;
					chargeCost = 250;
					if (entity.getPersistentData().getDouble("sn_Charge_2") <= maxCharge) {
						entity.getPersistentData().putDouble("sn_Charge_1", (entity.getPersistentData().getDouble("sn_Charge_1") + 1));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Charge: " + Math.round(entity.getPersistentData().getDouble("sn_Charge_2")))), true);
						if (entity.getPersistentData().getDouble("sn_Charge_1") == 10
								&& (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool >= chargeCost) {
							entity.getPersistentData().putDouble("sn_Charge_1", 0);
							entity.getPersistentData().putDouble("sn_Charge_2", (entity.getPersistentData().getDouble("sn_Charge_2") + 1));
							{
								double _setval = (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool - chargeCost;
								entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraPool = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("sn_currentJutsu") == 4) {
					maxCharge = 5;
					chargeCost = 2500;
					if (entity.getPersistentData().getDouble("sn_Charge_2") <= maxCharge) {
						entity.getPersistentData().putDouble("sn_Charge_1", (entity.getPersistentData().getDouble("sn_Charge_1") + 1));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Charge: " + Math.round(entity.getPersistentData().getDouble("sn_Charge_2")))), true);
						if (entity.getPersistentData().getDouble("sn_Charge_1") == 10
								&& (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool >= chargeCost) {
							entity.getPersistentData().putDouble("sn_Charge_1", 0);
							entity.getPersistentData().putDouble("sn_Charge_2", (entity.getPersistentData().getDouble("sn_Charge_2") + 1));
							{
								double _setval = (entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).ChakraPool - chargeCost;
								entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraPool = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
	}
}
