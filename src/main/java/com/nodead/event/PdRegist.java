package com.nodead.event;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PdRegist {
/**
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        LiteralArgumentBuilder<CommandSourceStack> command = Commands.literal("n")
                        .then(Commands.literal("t")
                                .executes(context -> truediamond(context.getSource()))
                        )
                        .then(Commands.literal("f")
                                .executes(context -> falsediamond(context.getSource()))
                        );





        dispatcher.register(command);
    }
    public static boolean diamondflag = false;
    private static int truediamond(CommandSourceStack source) {
        Player player = source.getEntity() instanceof Player ? (Player) source.getEntity() : null;

        if(diamondflag == true){
            System.out.println("Already TRUE");
        }else{
            diamondflag = true;
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE));
        }
        // Start your stopwatch logic here
        return 0;
    }

    private static int falsediamond(CommandSourceStack source) {
        Player player = source.getEntity() instanceof Player ? (Player) source.getEntity() : null;

        if(diamondflag == false){
            System.out.println("Already FALSE");
        }else{
            diamondflag = false;
            player.removeAllEffects();
        }        // Pause your stopwatch logic here
        return 0;
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(PdRegist.class);
    }
    **/
}
