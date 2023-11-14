
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import com.coder2195.notjavascript.world.features.ores.UraniumOreFeature;
import com.coder2195.notjavascript.NotJavascriptMod;

@Mod.EventBusSubscriber
public class NotJavascriptModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, NotJavascriptMod.MODID);
	public static final RegistryObject<Feature<?>> URANIUM_ORE = REGISTRY.register("uranium_ore", UraniumOreFeature::new);
}
