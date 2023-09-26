package com.nodead.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.EntityLeaveLevelEvent;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class PdTnt {




    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        if (!event.getLevel().isClientSide() && event.getEntity() instanceof PrimedTnt) {
            PrimedTnt tntEntity = (PrimedTnt) event.getEntity();
            Level world = tntEntity.level;

            tntEntity.setSecondsOnFire(0);
            // TNTエンティティが生成されたら、その位置に新しいTNTブロックを設置
            BlockPos pos = tntEntity.blockPosition();
            world.setBlockAndUpdate(pos, Blocks.TNT.defaultBlockState());
        }
    }
    @SubscribeEvent
    public static void onExplosionStart(ExplosionEvent.Start event) {
        if (event.getExplosion().getExploder() instanceof PrimedTnt) {
            // TNTエンティティの爆発をキャンセルする
            event.setCanceled(true);
        }
    }
    @SubscribeEvent
    public static void onEntityLeaveWorld(EntityLeaveLevelEvent event) {
        if (!event.getLevel().isClientSide() && event.getEntity().getType() == EntityType.TNT) {
            Level world = event.getLevel();
            double x = event.getEntity().getX();
            double y = event.getEntity().getY();
            double z = event.getEntity().getZ();

            // TNTエンティティが削除されたら、その位置に新しいTNTブロックを設置
            world.setBlockAndUpdate(new BlockPos(x,y ,z), Blocks.TNT.defaultBlockState());
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdTnt.class);
    }
}
