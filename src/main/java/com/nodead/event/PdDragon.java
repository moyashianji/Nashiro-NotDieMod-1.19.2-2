package com.nodead.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PdDragon {
   /* @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        // ダメージを受けるエンティティがエンダードラゴンであるかどうかを確認
        if (event.getSource().getEntity() instanceof EnderDragon) {
            // ダメージソースがドラゴンブレスでない場合、ダメージを無効化
                System.out.println("gggg");
                event.getEntity().hurt(DamageSource.DRAGON_BREATH,3);

        }
    }*/
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdDragon.class);
    }
}
