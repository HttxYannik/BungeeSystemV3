package dev.shyzouka.bungeesystem;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeeSystem extends Plugin {
    private static BungeeSystem instance;
    private static String prefix = "";

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

}
