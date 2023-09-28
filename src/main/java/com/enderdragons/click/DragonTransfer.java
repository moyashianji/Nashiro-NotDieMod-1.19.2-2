package com.enderdragons.click;

import com.enderdragons.entity.EnderWingsEntity;
import com.enderdragons.entity.EnderbodyEntity;
import com.enderdragons.entity.EndertailsEntity;
import com.enderdragons.init.EnderdragonsModEntities;
import com.enderdragons.init.EnderdragonsModItems;
import com.nodead.event.PdGolem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

public class DragonTransfer {


    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getEntity();

        if (player != null && player.getMainHandItem().getItem() == EnderdragonsModItems.ENDERTAIL.get()) { // 例: 右クリックでEnderbodyEntityをキル
            Entity targetEntity = event.getTarget();
            System.out.println("aaa");
            if (targetEntity instanceof EnderbodyEntity) {
                System.out.println("ccc");

                EnderbodyEntity enderbody = (EnderbodyEntity) targetEntity;
                if (!enderbody.level.isClientSide()) {
                    // EnderbodyEntityをキル
                    enderbody.discard();

                    EndertailsEntity tails = EnderdragonsModEntities.ENDERTAILS.get().create(player.level);
                    tails.setPos(enderbody.getX(),enderbody.getY(),enderbody.getZ());
                    event.getLevel().addFreshEntity(tails);

                }
            }

        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(DragonTransfer.class);
    }

}
