package com.cactus;

import com.cactus.entity.CactusEntity;
import com.dropitem.DropItems;
import com.mojang.math.Vector3d;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.nodead.event.PdMob.RADIUS;

public class NearCactusEvent {

    public static double shortsize = 1.0;
    private double zombiedistance = 0.0;
    private double differencevalue = 0.0;
    private double positionvalue = 16.0;
    private double finalvalue = 0.0;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        System.out.println("aaaaa");
        if (event.phase == TickEvent.Phase.START) {
            // プレイヤーの周りにいるゾンビエンティティとの距離を取得するコードをここに追加
            getZombieDistance();
        }
    }
    public static float aaa = 1.0F; // 初期値を設定
    private static boolean timerStarted = false; // タイマーが開始されたかどうかを示すフラグ
    private static Timer timer; // タイマーオブジェクト
    public static boolean cooltime = false;
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
                for (Entity entity : world.getEntities(player, player.getBoundingBox().inflate(shortsize))) {
                    if (entity instanceof CactusEntity && entity != player && !(entity instanceof Player)) {
                        if (cooltime == false) {
                            cooltime = true;
                            // ゾンビを右クリックしたらタイマーを開始
                            if (!timerStarted) {
                                timerStarted = true; // タイマーを開始
                                timer = new Timer();
                                timer.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                        // aaa の値を0.5秒ごとに1減少
                                        aaa -= 0.05;
                                        System.out.println("aaa の値: " + aaa);

                                        // aaa が 0 以下になったらタイマーを停止
                                        if (aaa <= 0.2) {
                                            timer.cancel();
                                            System.out.println("タイマーを停止しました");
                                            timerStarted = false;
                                        }
                                    }
                                }, 0, 250); // 初回実行の遅延時間（0ミリ秒）、タスクの実行間隔（500ミリ秒＝0.5秒）
                            }
                        }
                    }
                }
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {

        Entity target = event.getTarget();
        if (event.getTarget() instanceof CactusEntity) {
            aaa = 1.0F;
            cooltime = false;
        }
    }

    private void getZombieDistance() {
        System.out.println("aaaaa");
        Minecraft mc = Minecraft.getInstance();
        Entity player = mc.player;
        Vec3 playerPos = player.getEyePosition();
        double radius = 10.0; // プレイヤーの周りの半径

        AABB searchBox = new AABB(
                playerPos.x - radius, playerPos.y - radius, playerPos.z - radius,
                playerPos.x + radius, playerPos.y + radius, playerPos.z + radius
        );

        List<Entity> entities = mc.level.getEntities(player, searchBox, entity -> entity instanceof Zombie);

        // ゾンビエンティティとの距離を計算する
        for (Entity entity : entities) {
            Zombie zombie = (Zombie) entity;
            Vec3 zombiePos = zombie.getEyePosition();
            double distance = playerPos.distanceTo(zombiePos);

            // ここで距離を処理するコードを記述
            // 例えば、距離をコンソールに表示する場合は
            System.out.println("プレイヤーとゾンビの距離: " + distance);
        }
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(NearCactusEvent.class);
    }
}





