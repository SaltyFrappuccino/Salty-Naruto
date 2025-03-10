package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.Entity;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;
import net.mcreator.saltynaruto.init.SaltyNarutoModEntities;
import net.mcreator.saltynaruto.entity.FireballEntity;

public class FireballJutsuProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _shootFrom = entity;
			Level projectileLevel = _shootFrom.level();
			if (!projectileLevel.isClientSide()) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
						AbstractArrow entityToSpawn = new FireballEntity(SaltyNarutoModEntities.FIREBALL.get(), level);
						entityToSpawn.setOwner(shooter);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, entity,
						(float) (entity.getPersistentData().getDouble("sn_Charge_2") * ((entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaltyNarutoModVariables.PlayerVariables())).Ninjutsu / 10)), 30);
				_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
				_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
	}
}
