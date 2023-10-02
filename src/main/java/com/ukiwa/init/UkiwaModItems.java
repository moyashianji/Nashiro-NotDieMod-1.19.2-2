
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ukiwa.init;

import com.main.reference;
import com.ukiwa.item.UkiwabouguItem;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;



public class UkiwaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, reference.MOD_ID);
	public static final RegistryObject<Item> UKIWABOUGU_CHESTPLATE = REGISTRY.register("ukiwabougu_chestplate",
			() -> new UkiwabouguItem.Chestplate());
}
