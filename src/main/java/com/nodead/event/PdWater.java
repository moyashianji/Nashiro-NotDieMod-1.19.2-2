package com.nodead.event;

import com.mojang.math.Vector3d;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.Vector;

public class PdWater {

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
    @SubscribeEvent
    public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.isInWater()) {
                Vec3 motion = player.getDeltaMovement();
                player.lerpMotion(motion.x, 0.1D, motion.z); // 上方向に浮上する速度を設定
            }
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdWater.class);
    }
}
