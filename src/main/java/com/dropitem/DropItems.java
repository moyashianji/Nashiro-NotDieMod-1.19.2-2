package com.dropitem;

import com.itemmod.init.ItemmodModItems;
import com.nodead.event.KeyGod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DropItems {
    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        Entity entity = event.getEntity();

        // エンティティがオオカミであるかをチェック
        if (entity instanceof Wolf) {
            Wolf wolf = (Wolf) entity;
            int dropAmount = 1; // 1つの土ブロックをドロップ

            // ItemEntityを生成して土ブロックをドロップします
            ItemEntity itemEntity = new ItemEntity(
                    event.getEntity().level,
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(ItemmodModItems.WOLFTAIL.get(), dropAmount)
            );

            // ItemEntityを追加します
            event.getDrops().add(itemEntity);
        }

        if (entity instanceof Horse) {
            Horse wolf = (Horse) entity;
            int dropAmount = 1; // 1つの土ブロックをドロップ

            // ItemEntityを生成して土ブロックをドロップします
            ItemEntity itemEntity = new ItemEntity(
                    event.getEntity().level,
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(ItemmodModItems.HORSETAIL.get(), dropAmount)
            );

            // ItemEntityを追加します
            event.getDrops().add(itemEntity);
        }
        if (entity instanceof Bee) {
            Bee wolf = (Bee) entity;
            int dropAmount = 1; // 1つの土ブロックをドロップ

            // ItemEntityを生成して土ブロックをドロップします
            ItemEntity itemEntity = new ItemEntity(
                    event.getEntity().level,
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(ItemmodModItems.BEEWINGS.get(), dropAmount)
            );

            // ItemEntityを追加します
            event.getDrops().add(itemEntity);
        }
        if (entity instanceof Vex) {
            Vex wolf = (Vex) entity;
            int dropAmount = 1; // 1つの土ブロックをドロップ

            // ItemEntityを生成して土ブロックをドロップします
            ItemEntity itemEntity = new ItemEntity(
                    event.getEntity().level,
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(ItemmodModItems.VEXWINGS.get(), dropAmount)
            );

            // ItemEntityを追加します
            event.getDrops().add(itemEntity);
        }

        if (entity instanceof Hoglin) {
            Hoglin wolf = (Hoglin) entity;
            int dropAmount = 1; // 1つの土ブロックをドロップ

            // ItemEntityを生成して土ブロックをドロップします
            ItemEntity itemEntity = new ItemEntity(
                    event.getEntity().level,
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(ItemmodModItems.HOGLINTAIL.get(), dropAmount)
            );

            // ItemEntityを追加します
            event.getDrops().add(itemEntity);
        }
        if (entity instanceof Silverfish) {
            Silverfish wolf = (Silverfish) entity;
            int dropAmount = 1; // 1つの土ブロックをドロップ

            // ItemEntityを生成して土ブロックをドロップします
            ItemEntity itemEntity = new ItemEntity(
                    event.getEntity().level,
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(ItemmodModItems.SILVERFISHTAIL.get(), dropAmount)
            );

            // ItemEntityを追加します
            event.getDrops().add(itemEntity);
        }

        if (entity instanceof Endermite) {
            Endermite wolf = (Endermite) entity;
            int dropAmount = 1; // 1つの土ブロックをドロップ

            // ItemEntityを生成して土ブロックをドロップします
            ItemEntity itemEntity = new ItemEntity(
                    event.getEntity().level,
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(ItemmodModItems.ENDERMITEEYE.get(), dropAmount)
            );

            // ItemEntityを追加します
            event.getDrops().add(itemEntity);
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(DropItems.class);
    }

}
