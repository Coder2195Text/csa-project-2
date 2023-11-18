
package com.coder2195.notjavascript.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NuclearBombCoreItem extends Item {
	public NuclearBombCoreItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
