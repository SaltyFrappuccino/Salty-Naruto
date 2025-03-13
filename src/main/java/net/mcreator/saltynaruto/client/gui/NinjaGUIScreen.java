package net.mcreator.saltynaruto.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.saltynaruto.network.SaltyNarutoModVariables;
import net.mcreator.saltynaruto.init.SaltyNarutoModItems;

import net.mcreator.saltynaruto.world.inventory.NinjaGUIMenu;
import net.mcreator.saltynaruto.procedures.*;
import net.mcreator.saltynaruto.network.NinjaGUIButtonMessage;
import net.mcreator.saltynaruto.SaltyNarutoMod;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NinjaGUIScreen extends AbstractContainerScreen<NinjaGUIMenu> {
    private final static HashMap<String, Object> guistate = NinjaGUIMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    
    // Объявляем все кнопки
    Button button_plus_ninjutu;
    Button button_plus_taijutsu;
    Button button_plus_genjutsu;
    Button button_plus_senjutsu;
    Button button_plus_summoning;
    Button button_plus_ireninjutsu;
    Button button_plus_strength;
    Button button_plus_durability;
    Button button_plus_chakra;

    public NinjaGUIScreen(NinjaGUIMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 360;
        this.imageHeight = 220;
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
        
        // Убрана горизонтальная линия
        guiGraphics.fill(this.leftPos + 90, this.topPos + 10, this.leftPos + 95, this.topPos + 200, 0xFF404040);
        guiGraphics.fill(this.leftPos + 230, this.topPos + 10, this.leftPos + 235, this.topPos + 200, 0xFF404040);
        
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
        // Общие отступы
        int leftColumnX = 5;
        int centerColumnX = 105;
        int rightColumnX = 245;
        
        // Левая колонка
        guiGraphics.drawString(this.font, "§lPlayer Info", leftColumnX, 15, 0xFF3366FF, false);
        guiGraphics.drawString(this.font, "§lLevel: §r" + ReturnPlayerLevelProcedure.execute(this.entity), leftColumnX, 35, -1, false);
        guiGraphics.drawString(this.font, "§lXP: §r" + ReturnPlayerExperienceProcedure.execute(this.entity), leftColumnX, 50, -1, false);
        guiGraphics.drawString(this.font, "§lClan: §r" + ReturnPlayerClanProcedure.execute(this.entity), leftColumnX, 65, -1, false);

        // Центральная колонка
        guiGraphics.drawString(this.font, "§lSkills", centerColumnX, 15, 0xFF3366FF, false);
        guiGraphics.drawString(this.font, "§lNinjutsu: §r" + ReturnNinjutusLevelProcedure.execute(this.entity), centerColumnX, 35, -1, false);
        guiGraphics.drawString(this.font, "§lTaijutsu: §r" + ReturnTaijutsuLevelProcedure.execute(this.entity), centerColumnX, 55, -1, false);
        guiGraphics.drawString(this.font, "§lGenjutsu: §r" + ReturnGenjutsuLevelProcedure.execute(this.entity), centerColumnX, 75, -1, false);
        guiGraphics.drawString(this.font, "§lSenjutsu: §r" + ReturnSenjutsuLevelProcedure.execute(this.entity), centerColumnX, 95, -1, false);
        guiGraphics.drawString(this.font, "§lSummoning: §r" + ReturnSummoningLevelProcedure.execute(this.entity), centerColumnX, 115, -1, false);
        guiGraphics.drawString(this.font, "§lIreninjutsu: §r" + ReturnIreninjutsuLevelProcedure.execute(this.entity), centerColumnX, 135, -1, false);

        guiGraphics.drawString(this.font, "§lNature Releases", centerColumnX, 155, 0xFF3366FF, false);
        drawNatureReleases(guiGraphics, centerColumnX, 165);
        // Правая колонка
        guiGraphics.drawString(this.font, "§lAttributes", rightColumnX, 15, 0xFF3366FF, false);
        guiGraphics.drawString(this.font, "§lChakra: §r" + ReturnChakraMaxCapacityProcedure.execute(this.entity), rightColumnX, 35, -1, false);
        guiGraphics.drawString(this.font, "§lStrength: §r" + ReturnPlayerStrengthProcedure.execute(this.entity), rightColumnX, 55, -1, false);
        guiGraphics.drawString(this.font, "§lDurability: §r" + ReturnPlayerDurabilitiesProcedure.execute(this.entity), rightColumnX, 75, -1, false);
        guiGraphics.drawString(this.font, "§lIntelligence: §r" + ReturnPlayerIntelligenceProcedure.execute(this.entity), rightColumnX, 95, -1, false);

                guiGraphics.drawString(this.font, "§lKekkei Genkai", rightColumnX, 115, 0xFF3366FF, false);
        drawKekkeiGenkai(guiGraphics, rightColumnX, 130);
        // Ресурсы
        guiGraphics.drawString(this.font, "§lResources", leftColumnX, 115, 0xFF3366FF, false);
        guiGraphics.drawString(this.font, "§lLP: §r" + ReturnLevelPointsProcedure.execute(this.entity), leftColumnX, 130, -1, false);
        guiGraphics.drawString(this.font, "§lJP: §r" + ReturnJutsuPointsProcedure.execute(this.entity), leftColumnX, 145, -1, false);
    }

    private void drawNatureReleases(GuiGraphics guiGraphics, int x, int y) {
    List<String> releases = new ArrayList<>();
    SaltyNarutoModVariables.PlayerVariables vars = getVars(); // Получаем Capability
    
    if(vars.FireRelease) releases.add("§l§cFire");
    if(vars.WindRelease) releases.add("§l§aWind");
    if(vars.WaterRelease) releases.add("§l§9Water");
    if(vars.LightningRelease) releases.add("§l§eLightning");
    if(vars.EarthRelease) releases.add("§l§6Earth");
    if(vars.YinRelease) releases.add("§l§5Yin");
    if(vars.YangRelease) releases.add("§l§dYang");

    drawWrappedText(guiGraphics, releases, x, y, 100);
}

private void drawKekkeiGenkai(GuiGraphics guiGraphics, int x, int y) {
    List<String> kekkeiGenkai = new ArrayList<>();
    SaltyNarutoModVariables.PlayerVariables vars = getVars();
    
    if(vars.BoilRelease) kekkeiGenkai.add("§l§cBoil");
    if(vars.ExplosionRelease) kekkeiGenkai.add("§l§4Explosion");
    if(vars.IceRelease) kekkeiGenkai.add("§l§bIce");
    if(vars.LavaRelease) kekkeiGenkai.add("§l§6Lava");
    if(vars.MagnetRelease) kekkeiGenkai.add("§l§7Magnet");
    if(vars.ScorchRelease) kekkeiGenkai.add("§l§eScorch");
    if(vars.StormRelease) kekkeiGenkai.add("§l§1Storm");
    if(vars.DustRelease) kekkeiGenkai.add("§l§8Dust");
    if(vars.WoodRelease) kekkeiGenkai.add("§l§2Wood");
    if(vars.SharinganRelease) kekkeiGenkai.add("§l§dSharingan");
    if(vars.ByakuganRelease) kekkeiGenkai.add("§l§fByakugan");
    if(vars.RinneganRelease) kekkeiGenkai.add("§l§5Rinnegan");

    drawWrappedText(guiGraphics, kekkeiGenkai, x, y, 100);
}

private SaltyNarutoModVariables.PlayerVariables getVars() {
    return entity.getCapability(SaltyNarutoModVariables.PLAYER_VARIABLES_CAPABILITY)
                 .orElse(new SaltyNarutoModVariables.PlayerVariables());
}

    private void drawWrappedText(GuiGraphics guiGraphics, List<String> entries, int x, int y, int maxWidth) {
        int currentX = x;
        int currentY = y;
        for(String entry : entries) {
            int textWidth = this.font.width(entry);
            if(currentX + textWidth > x + maxWidth) {
                currentX = x;
                currentY += 12;
            }
            guiGraphics.drawString(this.font, entry, currentX, currentY, -1, false);
            currentX += textWidth + 5;
        }
    }

    @Override
    public void init() {
        super.init();
        int leftColumnX = 10;
        int centerColumnX = 105;
        int rightColumnX = 245;
        // Параметры для кнопок
        int buttonOffsetX = 90; // Отступ от текста
        int buttonSize = 14;
        
        // Кнопки для навыков
        this.button_plus_ninjutu = createPlusButton(centerColumnX + buttonOffsetX, 30, 0);
        this.button_plus_taijutsu = createPlusButton(centerColumnX + buttonOffsetX, 50, 1);
        this.button_plus_genjutsu = createPlusButton(centerColumnX + buttonOffsetX, 70, 2);
        this.button_plus_senjutsu = createPlusButton(centerColumnX + buttonOffsetX, 90, 4);
        this.button_plus_summoning = createPlusButton(centerColumnX + buttonOffsetX, 110, 3);
        this.button_plus_ireninjutsu = createPlusButton(centerColumnX + buttonOffsetX, 130, 5);

        // Кнопки для атрибутов
        this.button_plus_chakra = createPlusButton(rightColumnX + buttonOffsetX, 30, 6);
        this.button_plus_strength = createPlusButton(rightColumnX + buttonOffsetX, 50, 7);
        this.button_plus_durability = createPlusButton(rightColumnX + buttonOffsetX, 70, 8);

        this.addRenderableWidget(this.button_plus_ninjutu);
        this.addRenderableWidget(this.button_plus_taijutsu);
        this.addRenderableWidget(this.button_plus_genjutsu);
        this.addRenderableWidget(this.button_plus_senjutsu);
        this.addRenderableWidget(this.button_plus_summoning);
        this.addRenderableWidget(this.button_plus_ireninjutsu);
        this.addRenderableWidget(this.button_plus_strength);
        this.addRenderableWidget(this.button_plus_durability);
        this.addRenderableWidget(this.button_plus_chakra);
    }

    private Button createPlusButton(int x, int y, int buttonID) {
        return Button.builder(Component.literal("+"), e -> {
            SaltyNarutoMod.PACKET_HANDLER.sendToServer(
                new NinjaGUIButtonMessage(buttonID, this.x, this.y, this.z)
            );
            NinjaGUIButtonMessage.handleButtonAction(this.entity, buttonID, this.x, this.y, this.z);
        })
        .bounds(this.leftPos + x, this.topPos + y, 18, 18)
        .build();
    }
}