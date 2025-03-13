
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.saltynaruto.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.saltynaruto.SaltyNarutoMod;

public class SaltyNarutoModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SaltyNarutoMod.MODID);
	public static final RegistryObject<SimpleParticleType> ASH_AND_DUST = REGISTRY.register("ash_and_dust", () -> new SimpleParticleType(true));
}
