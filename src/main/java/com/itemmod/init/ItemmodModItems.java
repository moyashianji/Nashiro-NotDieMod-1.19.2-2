
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.itemmod.init;

import com.itemmod.item.*;
import com.main.reference;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;



import java.lang.ref.Reference;

public class ItemmodModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, reference.MOD_ID);
	public static final RegistryObject<Item> BEEWINGS = REGISTRY.register("beewings", () -> new BeewingsItem());
	public static final RegistryObject<Item> HORSETAIL = REGISTRY.register("horsetail", () -> new HorsetailItem());
	public static final RegistryObject<Item> WOLFTAIL = REGISTRY.register("wolftail", () -> new WolftailItem());
	public static final RegistryObject<Item> VEXWINGS = REGISTRY.register("vexwings", () -> new VexwingsItem());
	public static final RegistryObject<Item> HOGLINTAIL = REGISTRY.register("hoglintail", () -> new HoglintailItem());
	public static final RegistryObject<Item> SILVERFISHTAIL = REGISTRY.register("silverfishtail", () -> new SilverfishtailItem());
	public static final RegistryObject<Item> ENDERMITEEYE = REGISTRY.register("endermiteeye", () -> new EndermiteeyeItem());
	public static final RegistryObject<Item> BARRIERARMOR_HELMET = REGISTRY.register("barrierarmor_helmet", () -> new BarrierarmorItem.Helmet());
	public static final RegistryObject<Item> BARRIERARMOR_CHESTPLATE = REGISTRY.register("barrierarmor_chestplate",
			() -> new BarrierarmorItem.Chestplate());
	public static final RegistryObject<Item> BARRIERARMOR_LEGGINGS = REGISTRY.register("barrierarmor_leggings",
			() -> new BarrierarmorItem.Leggings());
	public static final RegistryObject<Item> BARRIERARMOR_BOOTS = REGISTRY.register("barrierarmor_boots", () -> new BarrierarmorItem.Boots());

}
