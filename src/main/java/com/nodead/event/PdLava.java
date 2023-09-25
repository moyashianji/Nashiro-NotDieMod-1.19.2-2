package com.nodead.event;

import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PdLava {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player != null) {
            Player player = event.player;

            // サーバーサイドのみで実行されるコード
            if (!player.level.isClientSide) {
                ServerLevel world = (ServerLevel) player.level;

                // プレイヤーがマグマに入る場合、ハートパーティクルを表示
                if (player.isInLava()) {
                    spawnHeartParticles(world, player);
                }

            }
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            // プレイヤーがダメージを受けた場合
            if (event.getSource() == DamageSource.LAVA) { // マグマからのダメージの場合（適切なダメージソースを指定）
                event.setCanceled(true); // ダメージを無効にする

            }
            if(event.getSource() == DamageSource.IN_FIRE){
                event.setCanceled(true);
            }
            if(event.getSource() == DamageSource.ON_FIRE){
                event.setCanceled(true);
            }
        }
    }
    private static void spawnHeartParticles(ServerLevel world, Player player) {
        // ハートパーティクルを生成して再生
        for (int i = 0; i < 3; i++) { // 必要な数だけ繰り返す
            double xOffset = player.getX() + (world.getRandom().nextDouble() - 0.5) * 2.0;
            double yOffset = player.getY() + player.getBbHeight() * 0.5;
            double zOffset = player.getZ() + (world.getRandom().nextDouble() - 0.5) * 2.0;
            world.sendParticles(ParticleTypes.HEART, xOffset, yOffset, zOffset, 1, 0.0, 0.0, 0.0, 0.0);
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdLava.class);
    }
}
