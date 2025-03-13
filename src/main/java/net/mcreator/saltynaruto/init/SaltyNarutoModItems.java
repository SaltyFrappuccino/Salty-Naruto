
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.saltynaruto.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.saltynaruto.item.FireReleaseItem;
import net.mcreator.saltynaruto.item.FireReleaseHidingInAshAndDustLearnerItem;
import net.mcreator.saltynaruto.item.FireReleaseGreatFireballJutsuLearnerItem;
import net.mcreator.saltynaruto.item.FireReleaseGreatFireDestructionLearnerItem;
import net.mcreator.saltynaruto.item.FireReleaseGreatFireAnnihilationLearnerItem;
import net.mcreator.saltynaruto.item.ClanRerollerItem;
import net.mcreator.saltynaruto.SaltyNarutoMod;

public class SaltyNarutoModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SaltyNarutoMod.MODID);
	public static final RegistryObject<Item> FIRE_RELEASE = REGISTRY.register("fire_release", () -> new FireReleaseItem());
	public static final RegistryObject<Item> FIRE_RELEASE_GREAT_FIREBALL_JUTSU_LEARNER = REGISTRY.register("fire_release_great_fireball_jutsu_learner", () -> new FireReleaseGreatFireballJutsuLearnerItem());
	public static final RegistryObject<Item> FIRE_RELEASE_GREAT_FIRE_DESTRUCTION_LEARNER = REGISTRY.register("fire_release_great_fire_destruction_learner", () -> new FireReleaseGreatFireDestructionLearnerItem());
	public static final RegistryObject<Item> CLAN_REROLLER = REGISTRY.register("clan_reroller", () -> new ClanRerollerItem());
	public static final RegistryObject<Item> FIRE_RELEASE_HIDING_IN_ASH_AND_DUST_LEARNER = REGISTRY.register("fire_release_hiding_in_ash_and_dust_learner", () -> new FireReleaseHidingInAshAndDustLearnerItem());
	public static final RegistryObject<Item> FIRE_RELEASE_GREAT_FIRE_ANNIHILATION_LEARNER = REGISTRY.register("fire_release_great_fire_annihilation_learner", () -> new FireReleaseGreatFireAnnihilationLearnerItem());
	// Start of user code block custom items
	// End of user code block custom items
}
