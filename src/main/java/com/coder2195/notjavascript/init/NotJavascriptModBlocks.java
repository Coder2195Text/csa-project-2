
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import com.coder2195.notjavascript.block.UraniumOreBlock;
import com.coder2195.notjavascript.block.UnluckyBlockBlock;
import com.coder2195.notjavascript.block.NuclearBombBlock;
import com.coder2195.notjavascript.block.LandmineBlock;
import com.coder2195.notjavascript.block.EnrichingTableBlock;
import com.coder2195.notjavascript.NotJavascriptMod;

public class NotJavascriptModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NotJavascriptMod.MODID);
	public static final RegistryObject<Block> URANIUM_ORE = REGISTRY.register("uranium_ore", () -> new UraniumOreBlock());
	public static final RegistryObject<Block> ENRICHING_TABLE = REGISTRY.register("enriching_table", () -> new EnrichingTableBlock());
	public static final RegistryObject<Block> NUCLEAR_BOMB = REGISTRY.register("nuclear_bomb", () -> new NuclearBombBlock());
	public static final RegistryObject<Block> LANDMINE = REGISTRY.register("landmine", () -> new LandmineBlock());
	public static final RegistryObject<Block> UNLUCKY_BLOCK = REGISTRY.register("unlucky_block", () -> new UnluckyBlockBlock());
}
