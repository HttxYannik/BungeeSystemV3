package dev.shyzouka.bungeesystem.spigotapi;

import org.bukkit.plugin.java.JavaPlugin;

public class SpigotAPI extends JavaPlugin {
    private static SpigotAPI instance;
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

    public static SpigotAPI getInstance() {
        return instance;
    }
}
