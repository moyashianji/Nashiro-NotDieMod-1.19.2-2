package com.nodead.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;
//・Pのキーを押すと、上昇する
public class KeyGod {
    private static final int KEY_P = GLFW.GLFW_KEY_X; // Pキーのキーコード
    private static boolean isPKeyPressed = false;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        // Minecraftインスタンスを取得
        Minecraft minecraft = Minecraft.getInstance();

        // Pキーが押されたかどうかを検出
        boolean isPKeyDown = GLFW.glfwGetKey(minecraft.getWindow().getWindow(), KEY_P) == GLFW.GLFW_PRESS;

        // Pキーの状態が変化した場合
        if (isPKeyDown != isPKeyPressed) {
            isPKeyPressed = isPKeyDown;

            // Pキーが押されている間、またはlevitationエフェクトが既に付与されている場合
            if (isPKeyPressed) {
                if (isPKeyPressed) {
                    // Pキーが押されている場合、levitationエフェクトを付与
                    minecraft.player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 1000000, 255));
                } else {
                    // Pキーが離された場合、levitationエフェクトを解除
                    minecraft.player.removeEffect(MobEffects.LEVITATION);
                }
            }
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(KeyGod.class);
    }
}
