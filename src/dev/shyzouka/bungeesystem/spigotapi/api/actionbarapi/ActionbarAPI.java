package dev.shyzouka.bungeesystem.spigotapi.api.actionbarapi;

import dev.shyzouka.core.Core;
import dev.shyzouka.core.spigot.SpigotCore;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class ActionbarAPI {

    private static Integer animatedTaskId;
    public void sendActionBar(Player player, String message) {
        CraftPlayer craftPlayer = (CraftPlayer)player;
        IChatBaseComponent iChatBaseComponent = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + message + "\"}");
        PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(iChatBaseComponent, (byte)2);
        (craftPlayer.getHandle()).playerConnection.sendPacket((Packet)packetPlayOutChat);
    }

    public void sendAnimatedActionbar(Player player, String[] animation, int updateIntervalTicks){

        final int[] currentAnimation = {0};
        final long ticks = updateIntervalTicks;

        if(currentAnimation[0] >= animation.length){
            currentAnimation[0] = 0;
        }

        BukkitScheduler task = Bukkit.getScheduler();

        animatedTaskId = task.scheduleAsyncRepeatingTask(SpigotCore.getInstance(), new Runnable() {
            @Override
            public void run() {
                sendActionBar(player, animation[currentAnimation[0]]);
                currentAnimation[0]++;
            }
        }, 0, ticks);

    }

    public static Integer getAnimatedTaskId() {
        return animatedTaskId;
    }
}
