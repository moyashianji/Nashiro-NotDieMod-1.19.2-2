package com.nodead.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PdBerry {
    private static final int DETECTION_RADIUS_SQUARED = 5; // ベリーを置換する範囲の半径（ブロック数の2乗）

    @SubscribeEvent
    public static void onPlayerTick(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            int playerX = (int) Math.floor(player.getX());
            int playerY = (int) Math.floor(player.getY());
            int playerZ = (int) Math.floor(player.getZ());

            // プレイヤーの周りにあるブロックをスキャン
            for (int x = playerX - 5; x <= playerX + 5; x++) {
                for (int y = playerY - 5; y <= playerY + 5; y++) {
                    for (int z = playerZ - 5; z <= playerZ + 5; z++) {
                        double distanceSquared = (x - playerX) * (x - playerX) + (y - playerY) * (y - playerY) + (z - playerZ) * (z - playerZ);

                        // プレイヤーから一定範囲内にベリーブロックがあるか確認
                        if (distanceSquared <= DETECTION_RADIUS_SQUARED && player.level.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.SWEET_BERRY_BUSH) {
                            // ベリーブロックを枯草に置換
                            player.level.setBlockAndUpdate(new BlockPos(x, y, z), Blocks.DEAD_BUSH.defaultBlockState());
                        }
                    }
                }
            }
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdBerry.class);
    }
}
