
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import com.coder2195.notjavascript.NotJavascriptMod;

public class NotJavascriptModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NotJavascriptMod.MODID);
	public static final RegistryObject<SoundEvent> NUCLEAR_SIREN = REGISTRY.register("nuclear_siren", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("not_javascript", "nuclear_siren")));
}
