package net.mcreator.saltynaruto.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class HidingInAshAndDustJutsuProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        // Проверка на нулевые объекты
        if (entity == null || world == null) return;
        
        double charge = entity.getPersistentData().getDouble("sn_Charge_2");
        if (charge <= 0) return;

        // Параметры эффекта
        int particleCount = (int) (charge * 1000);
        double radius = charge * 2.0;
        int fireDuration = (int) Math.min(charge, 20); // Ограничение до 20 секунд
        int blindnessDuration = (int) (charge * 20); // В тиках (1 сек = 20 тиков)

        // Создание частиц дыма
        if (world instanceof ServerLevel serverWorld) {
            // Сферическое распространение частиц
            for (int i = 0; i < particleCount; i++) {
                double angle = serverWorld.random.nextDouble() * Math.PI * 2;
                double spread = serverWorld.random.nextDouble() * radius;
                
                double dx = Math.cos(angle) * spread;
                double dz = Math.sin(angle) * spread;
                
                serverWorld.sendParticles(
                    ParticleTypes.LARGE_SMOKE,
                    x + dx,
                    y + serverWorld.random.nextDouble() * 2,
                    z + dz,
                    1,
                    0,
                    0.1,
                    0,
                    0.02
                );
            }
        }

        // Поиск целей в радиусе
        Vec3 center = new Vec3(x, y, z);
        AABB area = new AABB(
            center.x - radius,
            center.y - 2,
            center.z - radius,
            center.x + radius,
            center.y + 4,
            center.z + radius
        );

        List<Entity> targets = world.getEntitiesOfClass(
            Entity.class,
            area,
            e -> e != entity && e instanceof LivingEntity && e.isAlive()
        );

        // Применение эффектов
        for (Entity target : targets) {
            if (target instanceof LivingEntity livingTarget) {
                // Поджог
                livingTarget.setSecondsOnFire(fireDuration);
                
                // Слепота
                livingTarget.addEffect(new MobEffectInstance(
                    MobEffects.DARKNESS,
                    blindnessDuration,
                    1,
                    false,
                    false // Показывать частицы эффекта
                ));
                livingTarget.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SLOWDOWN,
                    blindnessDuration,
                    1,
                    false,
                    false // Показывать частицы эффекта
                ));
            }
        }

        // Сброс заряда после использования
        entity.getPersistentData().putDouble("sn_Charge_2", 0);
entity.getPersistentData().putDouble("sn_Charge_1", 0);
    }
}