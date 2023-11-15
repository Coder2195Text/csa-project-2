
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import com.coder2195.notjavascript.client.gui.EnrichingGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NotJavascriptModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(NotJavascriptModMenus.ENRICHING_GUI.get(), EnrichingGUIScreen::new);
		});
	}
}
