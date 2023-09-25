package com.nodead.event;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.server.ServerLifecycleHooks;

public class PdGolem {
    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        if (event.getEntity() instanceof IronGolem && event.getSource().getEntity() instanceof Player) {
            // アイアンゴーレムに攻撃された場合の処理
            event.setCanceled(true); // 攻撃を無効化

            MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
            _mcserv.getPlayerList().broadcastSystemMessage(Component.literal("メッセージ→ゴーレム：やめてください；；"), false);
        }
    }

    private static long lastInteractionTime = 0;
    private static final long INTERACTION_COOLDOWN = 1000; // インタラクションのクールダウン時間（ミリ秒）

    // プレイヤーがエンティティを右クリックしたときのイベントハンドラ
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastInteractionTime >= INTERACTION_COOLDOWN) {
            Entity target = event.getTarget();
            if (event.getTarget() instanceof IronGolem) {
                // アイアンゴーレムが左クリックされた場合の処理
                MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
                _mcserv.getPlayerList().broadcastSystemMessage(Component.literal("メッセージ→ゴーレム：体調悪いので殴れません；；"), false);
                lastInteractionTime = currentTime; // 最後のインタラクション時刻を更新

            }
        }
    }
    // プレイヤーが右クリックしたときのイベントハンドラ
    // プレイヤーがエンティティを右クリックしたときのイベントハンドラ

    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdGolem.class);
    }
}
