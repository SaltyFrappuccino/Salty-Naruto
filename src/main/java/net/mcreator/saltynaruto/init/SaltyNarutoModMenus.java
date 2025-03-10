
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.saltynaruto.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.saltynaruto.world.inventory.NinjaGUIMenu;
import net.mcreator.saltynaruto.SaltyNarutoMod;

public class SaltyNarutoModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, SaltyNarutoMod.MODID);
	public static final RegistryObject<MenuType<NinjaGUIMenu>> NINJA_GUI = REGISTRY.register("ninja_gui", () -> IForgeMenuType.create(NinjaGUIMenu::new));
}
