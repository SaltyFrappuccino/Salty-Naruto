package net.mcreator.saltynaruto.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;

import java.util.List;

public class GreatFireAnnihilationJutsuProcedure {

    private static final int FIRE_DURATION = 100;
    private static final float BASE_DAMAGE = 1.0f;
    private static final int WALL_SPAWN_DELAY = 2;

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null || world == null) return;

        double charge = entity.getPersistentData().getDouble("sn_Charge_2");
        if (charge <= 0) return;

        int wallHeight = Mth.clamp((int) charge * 2, 3, 7);
        int wallWidth = Mth.clamp((int) (charge * 3), 4, 12);
        int range = (int) (charge * 15);
        float damage = BASE_DAMAGE * (float) charge + getNinjutsuLevel(entity);

        Vec3 lookVec = entity.getLookAngle().normalize();

        createFireStream(world, entity, lookVec, charge);

        if (world instanceof ServerLevel serverWorld) {
            createFireWall(serverWorld, entity, x, y, z, lookVec, wallHeight, wallWidth, range, damage);
        }

        entity.getPersistentData().putDouble("sn_Charge_2", 0);
    }

    private static void createFireStream(LevelAccessor world, Entity entity, Vec3 direction, double charge) {
        if (world instanceof ServerLevel serverWorld) {
            Vec3 startPos = entity.getEyePosition(1.0f);
            int width = (int) (charge * 18);
            int height = (int) (charge * 12);
            Vec3 right = direction.cross(new Vec3(0, 1, 0)).normalize().scale(0.4);
            Vec3 up = new Vec3(0, 1, 0).scale(0.3);

            for (int step = 0; step < (charge * 30); step++) {
                Vec3 basePos = startPos.add(direction.scale(step * 0.6));
                for (int w = -width / 2; w <= width / 2; w++) {
                    for (int h = 0; h < height; h++) {
                        Vec3 particlePos = basePos.add(right.scale(w))
                            .add(up.scale(h))
                            .add(randomOffset(0.2));

                        serverWorld.sendParticles(
                            ParticleTypes.FLAME,
                            particlePos.x,
                            particlePos.y,
                            particlePos.z,
                            1,
                            0.05, 0.05, 0.05,
                            0.01
                        );
                    }
                }
            }

            serverWorld.playSound(
                null,
                BlockPos.containing(startPos),
                ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")),
                SoundSource.PLAYERS,
                1.0f,
                0.8f + serverWorld.random.nextFloat() * 0.4f
            );
        }
    }

    private static void applyDamageInArea(ServerLevel world, Vec3 center, float damage, Entity caster) {
        AABB area = new AABB(center, center).inflate(2.5);
        List<Entity> entities = world.getEntitiesOfClass(
            Entity.class,
            area,
            e -> e != caster && e.isAlive() && e instanceof LivingEntity
        );

        DamageSource damageSource = new DamageSource(
            world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(DamageTypes.ON_FIRE),
            caster
        );

        for (Entity target : entities) {
            target.hurt(damageSource, damage * 1.5f);
            target.setSecondsOnFire((int) (damage * 0.7f));
            Vec3 knockback = target.position().subtract(caster.position()).normalize().scale(0.3);
            target.setDeltaMovement(knockback);
        }
    }

private static void createFireWall(ServerLevel world, Entity caster, double x, double y, double z,
                                 Vec3 direction, int height, int width, int range, float damage) {
    Vec3 forward = direction.normalize().scale(0.3);
    Vec3 right = direction.cross(new Vec3(0, 1, 0)).normalize().scale(0.3);
    Vec3 up = new Vec3(0, 0.4, 0);

    for (int step = 0; step < range; step++) {
        final int currentStep = step;
        
        // Планируем обновление блока через задержку
        world.scheduleTick(
            new BlockPos(caster.blockPosition()), 
            Blocks.AIR, 
            currentStep * WALL_SPAWN_DELAY // Задержка в тиках
        );
        
        // Выполняем логику создания огня синхронно
        world.getServer().execute(() -> {
            Vec3 basePos = caster.position().add(forward.scale(currentStep * 0.8));
            
            for (int w = -width / 2; w <= width / 2; w++) {
                for (int h = 0; h < height; h++) {
                    Vec3 wallPos = basePos.add(right.scale(w))
                        .add(up.scale(h))
                        .add(randomOffset(0.3));

                    BlockPos bp = BlockPos.containing(wallPos);
                    if (world.isEmptyBlock(bp)) {
                        world.setBlock(bp, Blocks.FIRE.defaultBlockState(), 3);
                        scheduleBlockRemoval(world, bp);
                        applyDamageInArea(world, wallPos, damage, caster);

                        world.sendParticles(
                            ParticleTypes.FLAME,
                            wallPos.x, wallPos.y + 0.5, wallPos.z,
                            3, 0.2, 0.2, 0.2, 0.02
                        );
                    }
                }
            }

            if (currentStep % 3 == 0) {
                spawnEdgeEffects(world, basePos, right, width, height);
            }
        });
    }
}

    private static void spawnEdgeEffects(ServerLevel world, Vec3 pos, Vec3 right, int width, int height) {
        Vec3 frontCenter = pos.add(right.scale(width / 2));
        world.sendParticles(
            ParticleTypes.FLAME,
            frontCenter.x, frontCenter.y, frontCenter.z,
            10, 0.3, 1.0, 0.3, 0.1
        );
        world.sendParticles(
            ParticleTypes.LAVA,
            frontCenter.x, frontCenter.y, frontCenter.z,
            5, width * 0.2, 0.5, 0.2, 0.05
        );
    }

    private static void scheduleBlockRemoval(LevelAccessor world, BlockPos pos) {
        if (world instanceof ServerLevel serverWorld) {
            serverWorld.scheduleTick(pos, Blocks.FIRE, FIRE_DURATION);
        }
    }

    private static float getNinjutsuLevel(Entity entity) {
        return (float) entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY)
            .orElse(new SaltyNarutoModVariables.PlayerVariables())
            .Ninjutsu;
    }

    private static Vec3 randomOffset(double range) {
        return new Vec3(
            (Math.random() - 0.5) * range,
            (Math.random() - 0.5) * range,
            (Math.random() - 0.5) * range
        );
    }
}