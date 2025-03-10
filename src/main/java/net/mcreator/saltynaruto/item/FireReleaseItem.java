
package net.mcreator.saltynaruto.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FireReleaseItem extends Item {
	public FireReleaseItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}
}
