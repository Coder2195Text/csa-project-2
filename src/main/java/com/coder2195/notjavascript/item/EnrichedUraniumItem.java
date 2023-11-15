
package com.coder2195.notjavascript.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EnrichedUraniumItem extends Item {
	public EnrichedUraniumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
