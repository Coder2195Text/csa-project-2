
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import com.coder2195.notjavascript.world.inventory.EnrichingGUIMenu;
import com.coder2195.notjavascript.NotJavascriptMod;

public class NotJavascriptModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, NotJavascriptMod.MODID);
	public static final RegistryObject<MenuType<EnrichingGUIMenu>> ENRICHING_GUI = REGISTRY.register("enriching_gui", () -> IForgeMenuType.create(EnrichingGUIMenu::new));
}
