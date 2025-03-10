
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.saltynaruto.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.saltynaruto.network.SwitchJutsuMessage;
import net.mcreator.saltynaruto.network.StartJutsuMessage;
import net.mcreator.saltynaruto.network.OpenNinjaGUIKeybindMessage;
import net.mcreator.saltynaruto.network.EnableSharinganMessage;
import net.mcreator.saltynaruto.SaltyNarutoMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SaltyNarutoModKeyMappings {
	public static final KeyMapping SWITCH_JUTSU = new KeyMapping("key.salty_naruto.switch_jutsu", GLFW.GLFW_KEY_G, "key.categories.salty_naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SaltyNarutoMod.PACKET_HANDLER.sendToServer(new SwitchJutsuMessage(0, 0));
				SwitchJutsuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping START_JUTSU = new KeyMapping("key.salty_naruto.start_jutsu", GLFW.GLFW_KEY_Z, "key.categories.salty_naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SaltyNarutoMod.PACKET_HANDLER.sendToServer(new StartJutsuMessage(0, 0));
				StartJutsuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				START_JUTSU_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - START_JUTSU_LASTPRESS);
				SaltyNarutoMod.PACKET_HANDLER.sendToServer(new StartJutsuMessage(1, dt));
				StartJutsuMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ENABLE_SHARINGAN = new KeyMapping("key.salty_naruto.enable_sharingan", GLFW.GLFW_KEY_V, "key.categories.salty_naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SaltyNarutoMod.PACKET_HANDLER.sendToServer(new EnableSharinganMessage(0, 0));
				EnableSharinganMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_NINJA_GUI_KEYBIND = new KeyMapping("key.salty_naruto.open_ninja_gui_keybind", GLFW.GLFW_KEY_K, "key.categories.salty_naruto") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				SaltyNarutoMod.PACKET_HANDLER.sendToServer(new OpenNinjaGUIKeybindMessage(0, 0));
				OpenNinjaGUIKeybindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long START_JUTSU_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(SWITCH_JUTSU);
		event.register(START_JUTSU);
		event.register(ENABLE_SHARINGAN);
		event.register(OPEN_NINJA_GUI_KEYBIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				SWITCH_JUTSU.consumeClick();
				START_JUTSU.consumeClick();
				ENABLE_SHARINGAN.consumeClick();
				OPEN_NINJA_GUI_KEYBIND.consumeClick();
			}
		}
	}
}
