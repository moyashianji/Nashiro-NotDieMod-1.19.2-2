package com.nodead.event;

import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PdTnt {
    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide() || !(event.getEntity() instanceof PrimedTnt)) {
            return;
        }

        PrimedTnt tntEntity = (PrimedTnt) event.getEntity();
        Level world = tntEntity.getCommandSenderWorld();

        // TNTが着火されたかどうかをチェック
        if (tntEntity.isOnFire()) {
            // TNTが着火された場合、キルしてTNTブロックを設置
            event.setCanceled(true); // TNTエンティティの生成をキャンセル
            world.setBlockAndUpdate(tntEntity.blockPosition(), Blocks.TNT.defaultBlockState()); // TNTブロックを設置
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdTnt.class);
    }
}
