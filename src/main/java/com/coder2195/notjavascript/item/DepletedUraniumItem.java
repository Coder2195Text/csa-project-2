
package com.coder2195.notjavascript.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DepletedUraniumItem extends Item {
	public DepletedUraniumItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
