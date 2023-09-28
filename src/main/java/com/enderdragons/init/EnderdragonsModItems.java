
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.enderdragons.init;

import com.enderdragons.item.EnderaheadItem;
import com.enderdragons.item.EndertailItem;
import com.enderdragons.item.EnderwingItem;
import com.main.reference;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;


public class EnderdragonsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, reference.MOD_ID);
	public static final RegistryObject<Item> ENDERBODY = REGISTRY.register("enderbody_spawn_egg",
			() -> new ForgeSpawnEggItem(EnderdragonsModEntities.ENDERBODY, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> ENDER_WINGS = REGISTRY.register("ender_wings_spawn_egg",
			() -> new ForgeSpawnEggItem(EnderdragonsModEntities.ENDER_WINGS, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> ENDERTAILS = REGISTRY.register("endertails_spawn_egg",
			() -> new ForgeSpawnEggItem(EnderdragonsModEntities.ENDERTAILS, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> ENDERAHEAD = REGISTRY.register("enderahead", () -> new EnderaheadItem());
	public static final RegistryObject<Item> ENDERTAIL = REGISTRY.register("endertail", () -> new EndertailItem());
	public static final RegistryObject<Item> ENDERWING = REGISTRY.register("enderwing", () -> new EnderwingItem());

}
