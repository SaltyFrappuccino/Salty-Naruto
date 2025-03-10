package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class FireballJutsuExplosionFromEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity == sourceentity) == false) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, (float) (entity.getPersistentData().getDouble("sn_Charge_2") / 1), Level.ExplosionInteraction.MOB);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 500, 1, 1, 1, 0.2);
		}
	}
}
