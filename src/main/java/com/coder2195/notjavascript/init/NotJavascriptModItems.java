
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import com.coder2195.notjavascript.item.RawUraniumItem;
import com.coder2195.notjavascript.item.EnrichedUraniumItem;
import com.coder2195.notjavascript.NotJavascriptMod;

public class NotJavascriptModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NotJavascriptMod.MODID);
	public static final RegistryObject<Item> URANIUM_ORE = block(NotJavascriptModBlocks.URANIUM_ORE);
	public static final RegistryObject<Item> RAW_URANIUM = REGISTRY.register("raw_uranium", () -> new RawUraniumItem());
	public static final RegistryObject<Item> ENRICHING_TABLE = block(NotJavascriptModBlocks.ENRICHING_TABLE);
	public static final RegistryObject<Item> ENRICHED_URANIUM = REGISTRY.register("enriched_uranium", () -> new EnrichedUraniumItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
