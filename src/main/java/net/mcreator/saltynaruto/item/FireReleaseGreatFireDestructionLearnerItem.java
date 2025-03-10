
package net.mcreator.saltynaruto.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.saltynaruto.procedures.FireReleaseGreatFireDestructionLearnerRMBClickProcedure;

import java.util.List;

public class FireReleaseGreatFireDestructionLearnerItem extends Item {
	public FireReleaseGreatFireDestructionLearnerItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.salty_naruto.fire_release_great_fire_destruction_learner.description_0"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		FireReleaseGreatFireDestructionLearnerRMBClickProcedure.execute(entity);
		return ar;
	}
}
