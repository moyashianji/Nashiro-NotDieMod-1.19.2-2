package com.nodead.event;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PdWater {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player != null) {
            Player player = event.player;

            // プレイヤーが水中にいる場合、levitation エフェクトを付与
            if (player.isInWaterOrBubble()) {
                applyLevitationEffect(player);
            } else {
                // 水から出た場合、エフェクトをクリア
                clearLevitationEffect(player);
            }
        }
    }
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            // プレイヤーがダメージを受けた場合
            if (event.getSource() == DamageSource.DROWN) { // マグマからのダメージの場合（適切なダメージソースを指定）
                event.setCanceled(true); // ダメージを無効にする

            }

        }
    }
    private static void applyLevitationEffect(Player player) {
        // levitation エフェクトを付与
        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 1, false, false));
    }

    private static void clearLevitationEffect(Player player) {
        // levitation エフェクトをクリア
        player.removeEffect(MobEffects.LEVITATION);
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdWater.class);
    }
}
