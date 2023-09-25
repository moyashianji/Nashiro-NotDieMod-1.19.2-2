package com.nodead.event;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PdFall {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player != null) {
            Player player = event.player;

            // プレイヤーが空中にいる場合、slow_falling エフェクトを付与
            if (!player.isOnGround()) {
                applySlowFallingEffect(player);
            } else {
                // 地面に着地した場合、エフェクトをクリア
                clearSlowFallingEffect(player);
            }
        }
    }
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            // プレイヤーがダメージを受けた場合
            if (event.getSource() == DamageSource.FALL) { // マグマからのダメージの場合（適切なダメージソースを指定）
                event.setCanceled(true); // ダメージを無効にする
            }
        }
    }
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onPlayerFall(LivingFallEvent event) {
        // プレイヤーの落下ダメージを無効化
        if (event.getEntity() instanceof Player) {
            event.setDamageMultiplier(0.0F);
        }
    }

    private static void applySlowFallingEffect(Player player) {
        // slow_falling エフェクトがすでに付与されていない場合のみ付与
        if (!player.hasEffect(MobEffects.SLOW_FALLING)) {
            player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING));
        }

    }

    private static void clearSlowFallingEffect(Player player) {
        // slow_falling エフェクトをクリア
        player.removeEffect(MobEffects.SLOW_FALLING);
    }

    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdFall.class);
    }
}
