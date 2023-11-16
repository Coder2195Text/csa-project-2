
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import com.coder2195.notjavascript.block.entity.NuclearBombBlockEntity;
import com.coder2195.notjavascript.block.entity.EnrichingTableBlockEntity;
import com.coder2195.notjavascript.NotJavascriptMod;

public class NotJavascriptModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NotJavascriptMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ENRICHING_TABLE = register("enriching_table", NotJavascriptModBlocks.ENRICHING_TABLE, EnrichingTableBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NUCLEAR_BOMB = register("nuclear_bomb", NotJavascriptModBlocks.NUCLEAR_BOMB, NuclearBombBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
