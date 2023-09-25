package com.nodead.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PdDamage {
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            // プレイヤーがダメージを受けた場合
            if (event.getSource() == DamageSource.ANVIL
                    || event.getSource() == DamageSource.CACTUS
                    || event.getSource() == DamageSource.CRAMMING
                    || event.getSource() == DamageSource.DRY_OUT
                    || event.getSource() == DamageSource.FALLING_BLOCK
                    || event.getSource() == DamageSource.FALLING_STALACTITE
                    || event.getSource() == DamageSource.FLY_INTO_WALL
                    || event.getSource() == DamageSource.FREEZE
                    || event.getSource() == DamageSource.GENERIC
                    || event.getSource() == DamageSource.HOT_FLOOR
                    || event.getSource() == DamageSource.IN_WALL
                    || event.getSource() == DamageSource.LIGHTNING_BOLT
                    || event.getSource() == DamageSource.MAGIC
                    || event.getSource() == DamageSource.OUT_OF_WORLD
                    || event.getSource() == DamageSource.STALAGMITE
                    || event.getSource() == DamageSource.STARVE
                    || event.getSource() == DamageSource.SWEET_BERRY_BUSH
                    || event.getSource() == DamageSource.WITHER
            ) { // マグマからのダメージの場合（適切なダメージソースを指定）
                event.setCanceled(true); // ダメージを無効にする

            }

        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdDamage.class);
    }
}
