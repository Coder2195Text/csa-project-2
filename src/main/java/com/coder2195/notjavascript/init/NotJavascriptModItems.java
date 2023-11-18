
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
import com.coder2195.notjavascript.item.NuclearBombCoreItem;
import com.coder2195.notjavascript.item.EnrichedUraniumItem;
import com.coder2195.notjavascript.item.DepletedUraniumItem;
import com.coder2195.notjavascript.item.DepletedUraniumArmorItem;
import com.coder2195.notjavascript.NotJavascriptMod;

public class NotJavascriptModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NotJavascriptMod.MODID);
	public static final RegistryObject<Item> URANIUM_ORE = block(NotJavascriptModBlocks.URANIUM_ORE);
	public static final RegistryObject<Item> RAW_URANIUM = REGISTRY.register("raw_uranium", () -> new RawUraniumItem());
	public static final RegistryObject<Item> ENRICHING_TABLE = block(NotJavascriptModBlocks.ENRICHING_TABLE);
	public static final RegistryObject<Item> ENRICHED_URANIUM = REGISTRY.register("enriched_uranium", () -> new EnrichedUraniumItem());
	public static final RegistryObject<Item> NUCLEAR_BOMB = block(NotJavascriptModBlocks.NUCLEAR_BOMB);
	public static final RegistryObject<Item> NUCLEAR_BOMB_CORE = REGISTRY.register("nuclear_bomb_core", () -> new NuclearBombCoreItem());
	public static final RegistryObject<Item> LANDMINE = block(NotJavascriptModBlocks.LANDMINE);
	public static final RegistryObject<Item> DEPLETED_URANIUM = REGISTRY.register("depleted_uranium", () -> new DepletedUraniumItem());
	public static final RegistryObject<Item> DEPLETED_URANIUM_ARMOR_HELMET = REGISTRY.register("depleted_uranium_armor_helmet", () -> new DepletedUraniumArmorItem.Helmet());
	public static final RegistryObject<Item> DEPLETED_URANIUM_ARMOR_CHESTPLATE = REGISTRY.register("depleted_uranium_armor_chestplate", () -> new DepletedUraniumArmorItem.Chestplate());
	public static final RegistryObject<Item> DEPLETED_URANIUM_ARMOR_LEGGINGS = REGISTRY.register("depleted_uranium_armor_leggings", () -> new DepletedUraniumArmorItem.Leggings());
	public static final RegistryObject<Item> DEPLETED_URANIUM_ARMOR_BOOTS = REGISTRY.register("depleted_uranium_armor_boots", () -> new DepletedUraniumArmorItem.Boots());

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
