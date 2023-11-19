
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.coder2195.notjavascript.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import com.coder2195.notjavascript.entity.NuclearBombEntityEntity;
import com.coder2195.notjavascript.entity.NautiqueenEntity;
import com.coder2195.notjavascript.NotJavascriptMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NotJavascriptModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NotJavascriptMod.MODID);
	public static final RegistryObject<EntityType<NuclearBombEntityEntity>> NUCLEAR_BOMB_ENTITY = register("nuclear_bomb_entity", EntityType.Builder.<NuclearBombEntityEntity>of(NuclearBombEntityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NuclearBombEntityEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<NautiqueenEntity>> NAUTIQUEEN = register("nautiqueen",
			EntityType.Builder.<NautiqueenEntity>of(NautiqueenEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NautiqueenEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			NuclearBombEntityEntity.init();
			NautiqueenEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(NUCLEAR_BOMB_ENTITY.get(), NuclearBombEntityEntity.createAttributes().build());
		event.put(NAUTIQUEEN.get(), NautiqueenEntity.createAttributes().build());
	}
}
