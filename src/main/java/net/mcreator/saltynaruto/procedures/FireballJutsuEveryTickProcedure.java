package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class FireballJutsuEveryTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, y, z, 40, 0.5, 0.5, 0.5, 0.1);
	}
}
