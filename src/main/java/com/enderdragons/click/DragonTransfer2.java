package com.enderdragons.click;

import com.enderdragons.entity.EnderWingsEntity;
import com.enderdragons.entity.EnderbodyEntity;
import com.enderdragons.entity.EndertailsEntity;
import com.enderdragons.init.EnderdragonsModEntities;
import com.enderdragons.init.EnderdragonsModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DragonTransfer2 {

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();

        if (player != null && player.getMainHandItem().getItem() == EnderdragonsModItems.ENDERWING.get()) { // 例: 右クリックでEnderbodyEntityをキル
            Entity targetEntity = event.getTarget();
            System.out.println("aaa");
            if (targetEntity instanceof EndertailsEntity) {
                System.out.println("ccc");

                EndertailsEntity enderbody = (EndertailsEntity) targetEntity;
                if (!enderbody.level.isClientSide()) {
                    // EnderbodyEntityをキル
                    enderbody.discard();

                    EnderWingsEntity tails = EnderdragonsModEntities.ENDER_WINGS.get().create(player.level);
                    tails.setPos(enderbody.getX(),enderbody.getY(),enderbody.getZ());
                    event.getLevel().addFreshEntity(tails);

                }
            }

        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(DragonTransfer2.class);
    }
}
