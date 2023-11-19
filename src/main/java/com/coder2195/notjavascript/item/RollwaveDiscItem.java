
package com.coder2195.notjavascript.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class RollwaveDiscItem extends RecordItem {
	public RollwaveDiscItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("not_javascript:rollwave")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 4240);
	}
}
