
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.enderdragons.init;

import com.enderdragons.entity.EnderWingsEntity;
import com.enderdragons.entity.EnderbodyEntity;
import com.enderdragons.entity.EndertailsEntity;
import com.main.reference;
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



@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnderdragonsModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, reference.MOD_ID);
	public static final RegistryObject<EntityType<EnderbodyEntity>> ENDERBODY = register("enderbody",
			EntityType.Builder.<EnderbodyEntity>of(EnderbodyEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(3).setCustomClientFactory(EnderbodyEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EnderWingsEntity>> ENDER_WINGS = register("ender_wings",
			EntityType.Builder.<EnderWingsEntity>of(EnderWingsEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EnderWingsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EndertailsEntity>> ENDERTAILS = register("endertails",
			EntityType.Builder.<EndertailsEntity>of(EndertailsEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EndertailsEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			EnderbodyEntity.init();
			EnderWingsEntity.init();
			EndertailsEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(ENDERBODY.get(), EnderbodyEntity.createAttributes().build());
		event.put(ENDER_WINGS.get(), EnderWingsEntity.createAttributes().build());
		event.put(ENDERTAILS.get(), EndertailsEntity.createAttributes().build());
	}
}
