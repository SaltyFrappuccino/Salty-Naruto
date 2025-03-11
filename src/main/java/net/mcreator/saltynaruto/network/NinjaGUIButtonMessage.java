
package net.mcreator.saltynaruto.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.saltynaruto.world.inventory.NinjaGUIMenu;
import net.mcreator.saltynaruto.procedures.NinjaGUILevelUpTaijutsuProcedure;
import net.mcreator.saltynaruto.procedures.NinjaGUILevelUpSummoningProcedure;
import net.mcreator.saltynaruto.procedures.NinjaGUILevelUpSenjutsuProcedure;
import net.mcreator.saltynaruto.procedures.NinjaGUILevelUpNinjutsuProcedure;
import net.mcreator.saltynaruto.procedures.NinjaGUILevelUpIreninjutsuProcedure;
import net.mcreator.saltynaruto.procedures.NinjaGUILevelUpGenjutsuProcedure;
import net.mcreator.saltynaruto.SaltyNarutoMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NinjaGUIButtonMessage {
	private final int buttonID, x, y, z;

	public NinjaGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public NinjaGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(NinjaGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(NinjaGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = NinjaGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			NinjaGUILevelUpNinjutsuProcedure.execute(entity);
		}
		if (buttonID == 1) {

			NinjaGUILevelUpTaijutsuProcedure.execute(entity);
		}
		if (buttonID == 2) {

			NinjaGUILevelUpGenjutsuProcedure.execute(entity);
		}
		if (buttonID == 3) {

			NinjaGUILevelUpSummoningProcedure.execute(entity);
		}
		if (buttonID == 4) {

			NinjaGUILevelUpSenjutsuProcedure.execute(entity);
		}
		if (buttonID == 5) {

			NinjaGUILevelUpIreninjutsuProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SaltyNarutoMod.addNetworkMessage(NinjaGUIButtonMessage.class, NinjaGUIButtonMessage::buffer, NinjaGUIButtonMessage::new, NinjaGUIButtonMessage::handler);
	}
}
