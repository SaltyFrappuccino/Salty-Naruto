
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.saltynaruto.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.saltynaruto.entity.FireballEntity;
import net.mcreator.saltynaruto.entity.FireGreatDestructionProjectileEntity;
import net.mcreator.saltynaruto.SaltyNarutoMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SaltyNarutoModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SaltyNarutoMod.MODID);
	public static final RegistryObject<EntityType<FireballEntity>> FIREBALL = register("fireball",
			EntityType.Builder.<FireballEntity>of(FireballEntity::new, MobCategory.MISC).setCustomClientFactory(FireballEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(3f, 3f));
	public static final RegistryObject<EntityType<FireGreatDestructionProjectileEntity>> FIRE_GREAT_DESTRUCTION_PROJECTILE = register("fire_great_destruction_projectile",
			EntityType.Builder.<FireGreatDestructionProjectileEntity>of(FireGreatDestructionProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(FireGreatDestructionProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
