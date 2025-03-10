package net.mcreator.saltynaruto.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.saltynaruto.world.inventory.NinjaGUIMenu;
import net.mcreator.saltynaruto.procedures.ReturnTaijutsuLevelProcedure;
import net.mcreator.saltynaruto.procedures.ReturnPlayerLevelProcedure;
import net.mcreator.saltynaruto.procedures.ReturnPlayerExperienceProcedure;
import net.mcreator.saltynaruto.procedures.ReturnPlayerClanProcedure;
import net.mcreator.saltynaruto.procedures.ReturnNinjutusLevelProcedure;
import net.mcreator.saltynaruto.procedures.ReturnLevelPointsProcedure;
import net.mcreator.saltynaruto.procedures.ReturnJutsuPointsProcedure;
import net.mcreator.saltynaruto.procedures.ReturnGenjutsuLevelProcedure;
import net.mcreator.saltynaruto.network.NinjaGUIButtonMessage;
import net.mcreator.saltynaruto.SaltyNarutoMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NinjaGUIScreen extends AbstractContainerScreen<NinjaGUIMenu> {
	private final static HashMap<String, Object> guistate = NinjaGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	Button button_empty2;

	public NinjaGUIScreen(NinjaGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("salty_naruto:textures/screens/ninja_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnPlayerLevelProcedure.execute(entity), 6, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerExperienceProcedure.execute(entity), 5, 20, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnLevelPointsProcedure.execute(entity), 5, 36, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnJutsuPointsProcedure.execute(entity), 5, 49, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnNinjutusLevelProcedure.execute(entity), 5, 66, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnTaijutsuLevelProcedure.execute(entity), 5, 91, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnGenjutsuLevelProcedure.execute(entity), 5, 117, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnPlayerClanProcedure.execute(entity), 5, 138, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.salty_naruto.ninja_gui.button_empty"), e -> {
			if (true) {
				SaltyNarutoMod.PACKET_HANDLER.sendToServer(new NinjaGUIButtonMessage(0, x, y, z));
				NinjaGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 61, 30, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.salty_naruto.ninja_gui.button_empty1"), e -> {
			if (true) {
				SaltyNarutoMod.PACKET_HANDLER.sendToServer(new NinjaGUIButtonMessage(1, x, y, z));
				NinjaGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 86, 30, 20).build();
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_empty2 = Button.builder(Component.translatable("gui.salty_naruto.ninja_gui.button_empty2"), e -> {
			if (true) {
				SaltyNarutoMod.PACKET_HANDLER.sendToServer(new NinjaGUIButtonMessage(2, x, y, z));
				NinjaGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 112, 30, 20).build();
		guistate.put("button:button_empty2", button_empty2);
		this.addRenderableWidget(button_empty2);
	}
}
