package com.nodead.event;

import com.enderdragons.entity.EnderWingsEntity;
import com.enderdragons.entity.EnderbodyEntity;
import com.enderdragons.entity.EndertailsEntity;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class PdMob {

    private static final int RADIUS = 2; // 半径2マスの円内にいるモブにダメージを与える
    private static final int LEVITATIONRADIUS = 3;
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player != null) {
            Player player = event.player;
            Level world = player.level;

            // サーバーサイドのみで実行されるコード
            if (!world.isClientSide) {
                double playerX = player.getX();
                double playerY = player.getY();
                double playerZ = player.getZ();

                // 半径2マス以内にいるモブにダメージを与える
                for (Entity entity : world.getEntities(player, player.getBoundingBox().inflate(RADIUS))) {
                    if (entity instanceof LivingEntity && entity != player && !(entity instanceof Player)
                            && !(entity instanceof Creeper)
                            && !(entity instanceof Zombie)
                            && !(entity instanceof Spider)
                            && !(entity instanceof Skeleton)
                            && !(entity instanceof IronGolem)
                            && !(entity instanceof EnderDragon)
                            && !(entity instanceof EnderbodyEntity)
                            && !(entity instanceof EndertailsEntity)
                            && !(entity instanceof EnderWingsEntity)
                    ) {

                        // プレイヤー自身やモンスター以外のエンティティに対してのみ適用
                        LivingEntity livingEntity = (LivingEntity) entity;
                        livingEntity.hurt(DamageSource.GENERIC, 10000.0F); // 10,000のダメージを与える
                    }
                }

            }
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdMob.class);
    }
    // 以降のコードはクライアント側のイベント処理などを含みます
    // ...
}
