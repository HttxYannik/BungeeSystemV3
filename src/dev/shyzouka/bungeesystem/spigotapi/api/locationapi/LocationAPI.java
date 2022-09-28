package dev.shyzouka.bungeesystem.spigotapi.api.locationapi;

import java.io.File;

import dev.shyzouka.core.spigot.SpigotCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class LocationAPI {
    private File file = new File(SpigotCore.getInstance().getDataFolder(), "locations.yml");

    private YamlConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);

    public void set(Location loc, String path) {
        String w = loc.getWorld().getName();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        double pitch = loc.getPitch();
        double yaw = loc.getYaw();
        this.cfg.set(path + ".world", w);
        this.cfg.set(path + ".x", Double.valueOf(x));
        this.cfg.set(path + ".y", Double.valueOf(y));
        this.cfg.set(path + ".z", Double.valueOf(z));
        this.cfg.set(path + ".pitch", Double.valueOf(pitch));
        this.cfg.set(path + ".yaw", Double.valueOf(yaw));
        try {
            this.cfg.save(this.file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Location load(String path) {
        String w = this.cfg.getString(path + ".world");
        double x = this.cfg.getDouble(path + ".x");
        double y = this.cfg.getDouble(path + ".y");
        double z = this.cfg.getDouble(path + ".z");
        float yaw = (float)this.cfg.getDouble(path + ".yaw");
        float pitch = (float)this.cfg.getDouble(path + ".pitch");
        Location loc = new Location(Bukkit.getWorld(w), x, y, z, yaw, pitch);
        return loc;
    }

    public YamlConfiguration getCfg() {
        return this.cfg;
    }

    public File getFile() {
        return this.file;
    }
}
