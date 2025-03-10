package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;
import net.mcreator.saltynaruto.init.SaltyNarutoModItems;

public class LearnFireReleaseFireballJutsuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.FireRelease_FireballJutsu = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(SaltyNarutoModItems.FIRE_RELEASE_GREAT_FIREBALL_JUTSU_LEARNER.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
	}
}
