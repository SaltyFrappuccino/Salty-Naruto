package net.mcreator.saltynaruto.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;
import net.mcreator.saltynaruto.init.SaltyNarutoModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class FireReleaseRenderTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (itemstack.getItem() == SaltyNarutoModItems.FIRE_RELEASE.get()) {
			if ((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).FireRelease_FireballJutsu == true) {
				tooltip.add(Component.literal("Great Fireball"));
			}
			if ((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).FireRelease_GreatFireDestruction == true) {
				tooltip.add(Component.literal("Great Fire Destruction"));
			}
		}
	}
}
