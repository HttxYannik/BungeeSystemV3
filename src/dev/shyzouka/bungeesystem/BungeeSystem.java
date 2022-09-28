package dev.shyzouka.bungeesystem;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeeSystem extends Plugin {
    private static BungeeSystem instance;
    private static String prefix = "§8[§cBungeeSystem§8] §7";
    private static String usage = prefix + "Usage§8: §c";
    private static String broadcast = "§8[§cBroadcast§8] §7";

    @Override
    public void onEnable() {
        instance = this;



    }

    @Override
    public void onDisable() {

    }

    public static String getPrefix() {
        return prefix;
    }

    public static BungeeSystem getInstance() {
        return instance;
    }

    public static String getUsage() {
        return usage;
    }

    public static String getBroadcast() {
        return broadcast;
    }
    

}
