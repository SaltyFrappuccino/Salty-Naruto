package net.mcreator.saltynaruto.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.saltynaruto.SaltyNarutoMod;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SaltyNarutoModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		SaltyNarutoMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.ChakraPool = original.ChakraPool;
			clone.MaxChakra = original.MaxChakra;
			clone.PlayerLevel = original.PlayerLevel;
			clone.PlayerExperience = original.PlayerExperience;
			clone.JP = original.JP;
			clone.LP = original.LP;
			clone.Ninjutsu = original.Ninjutsu;
			clone.Genjutsu = original.Genjutsu;
			clone.Taijutsu = original.Taijutsu;
			clone.StrengthLevel = original.StrengthLevel;
			clone.DurabilityLevel = original.DurabilityLevel;
			clone.IntelligentLevel = original.IntelligentLevel;
			clone.SenjutsuLevel = original.SenjutsuLevel;
			clone.IreninjutsuLevel = original.IreninjutsuLevel;
			clone.SummoningLevel = original.SummoningLevel;
			clone.FireRelease_FireballJutsu = original.FireRelease_FireballJutsu;
			clone.Clan = original.Clan;
			clone.FireRelease_GreatFireDestruction = original.FireRelease_GreatFireDestruction;
			if (!event.isWasDeath()) {
				clone.sharingan = original.sharingan;
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("salty_naruto", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double ChakraPool = 0;
		public double MaxChakra = 0;
		public double PlayerLevel = 0;
		public double PlayerExperience = 0;
		public double JP = 0;
		public double LP = 0;
		public double Ninjutsu = 0;
		public double Genjutsu = 0;
		public double Taijutsu = 0;
		public double StrengthLevel = 0;
		public double DurabilityLevel = 0;
		public double IntelligentLevel = 0;
		public double SenjutsuLevel = 0;
		public double IreninjutsuLevel = 0;
		public double SummoningLevel = 0;
		public boolean FireRelease_FireballJutsu = false;
		public boolean sharingan = false;
		public String Clan = "\"\"";
		public boolean FireRelease_GreatFireDestruction = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				SaltyNarutoMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("ChakraPool", ChakraPool);
			nbt.putDouble("MaxChakra", MaxChakra);
			nbt.putDouble("PlayerLevel", PlayerLevel);
			nbt.putDouble("PlayerExperience", PlayerExperience);
			nbt.putDouble("JP", JP);
			nbt.putDouble("LP", LP);
			nbt.putDouble("Ninjutsu", Ninjutsu);
			nbt.putDouble("Genjutsu", Genjutsu);
			nbt.putDouble("Taijutsu", Taijutsu);
			nbt.putDouble("StrengthLevel", StrengthLevel);
			nbt.putDouble("DurabilityLevel", DurabilityLevel);
			nbt.putDouble("IntelligentLevel", IntelligentLevel);
			nbt.putDouble("SenjutsuLevel", SenjutsuLevel);
			nbt.putDouble("IreninjutsuLevel", IreninjutsuLevel);
			nbt.putDouble("SummoningLevel", SummoningLevel);
			nbt.putBoolean("FireRelease_FireballJutsu", FireRelease_FireballJutsu);
			nbt.putBoolean("sharingan", sharingan);
			nbt.putString("Clan", Clan);
			nbt.putBoolean("FireRelease_GreatFireDestruction", FireRelease_GreatFireDestruction);
			return nbt;
		}

		public void readNBT(Tag tag) {
			if (tag == null) {
				tag = writeNBT();
			}
			CompoundTag nbt = (CompoundTag) tag;
			if (nbt == null) {
				nbt = (CompoundTag) writeNBT();
			}
			ChakraPool = nbt.getDouble("ChakraPool");
			MaxChakra = nbt.getDouble("MaxChakra");
			PlayerLevel = nbt.getDouble("PlayerLevel");
			PlayerExperience = nbt.getDouble("PlayerExperience");
			JP = nbt.getDouble("JP");
			LP = nbt.getDouble("LP");
			Ninjutsu = nbt.getDouble("Ninjutsu");
			Genjutsu = nbt.getDouble("Genjutsu");
			Taijutsu = nbt.getDouble("Taijutsu");
			StrengthLevel = nbt.getDouble("StrengthLevel");
			DurabilityLevel = nbt.getDouble("DurabilityLevel");
			IntelligentLevel = nbt.getDouble("IntelligentLevel");
			SenjutsuLevel = nbt.getDouble("SenjutsuLevel");
			IreninjutsuLevel = nbt.getDouble("IreninjutsuLevel");
			SummoningLevel = nbt.getDouble("SummoningLevel");
			FireRelease_FireballJutsu = nbt.getBoolean("FireRelease_FireballJutsu");
			sharingan = nbt.getBoolean("sharingan");
			Clan = nbt.getString("Clan");
			FireRelease_GreatFireDestruction = nbt.getBoolean("FireRelease_GreatFireDestruction");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		SaltyNarutoMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.ChakraPool = message.data.ChakraPool;
					variables.MaxChakra = message.data.MaxChakra;
					variables.PlayerLevel = message.data.PlayerLevel;
					variables.PlayerExperience = message.data.PlayerExperience;
					variables.JP = message.data.JP;
					variables.LP = message.data.LP;
					variables.Ninjutsu = message.data.Ninjutsu;
					variables.Genjutsu = message.data.Genjutsu;
					variables.Taijutsu = message.data.Taijutsu;
					variables.StrengthLevel = message.data.StrengthLevel;
					variables.DurabilityLevel = message.data.DurabilityLevel;
					variables.IntelligentLevel = message.data.IntelligentLevel;
					variables.SenjutsuLevel = message.data.SenjutsuLevel;
					variables.IreninjutsuLevel = message.data.IreninjutsuLevel;
					variables.SummoningLevel = message.data.SummoningLevel;
					variables.FireRelease_FireballJutsu = message.data.FireRelease_FireballJutsu;
					variables.sharingan = message.data.sharingan;
					variables.Clan = message.data.Clan;
					variables.FireRelease_GreatFireDestruction = message.data.FireRelease_GreatFireDestruction;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
