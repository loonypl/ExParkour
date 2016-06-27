package io.github.krzysek.expk.utils;

import io.github.krzysek.expk.ExParkour;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class Parkour {

    protected final FileConfiguration config = new ExParkour().getConfig(ExParkour.cType.CONFIG);
    protected String name;
    protected Location spawn;

    public Parkour(String name, Location spawn) {
        this.name = name;
        this.spawn = spawn;
    }

    public Parkour(String name) {
        this.name = name;
    }

    public void register() {
        config.set("parkours." + name + ".spawn.world", spawn.getWorld().getName());
        config.set("parkours." + name + ".spawn.x", spawn.getX());
        config.set("parkours." + name + ".spawn.y", spawn.getY());
        config.set("parkours." + name + ".spawn.z", spawn.getZ());
        config.set("parkours." + name + ".spawn.yaw", spawn.getYaw());
        config.set("parkours." + name + ".spawn.pitch", spawn.getPitch());
    }

    public String getName() {
        return this.name;
    }

    public Location getSpawn() {
        return new Location(Bukkit.getWorld(config.getString("parkours." + name + ".spawn.world")), config.getDouble("parkours." + name + ".spawn.x"), config.getDouble("parkours." + name + ".spawn.y"), config.getDouble("parkours." + name + ".spawn.z"), Float.parseFloat(config.getString("parkours." + name + ".spawn.yaw")), Float.parseFloat(config.getString("parkours." + name + ".spawn.pitch")));
    }

    public void setSpawn() {
        config.set("parkours." + name + ".spawn.world", spawn.getWorld().getName());
        config.set("parkours." + name + ".spawn.x", spawn.getX());
        config.set("parkours." + name + ".spawn.y", spawn.getY());
        config.set("parkours." + name + ".spawn.z", spawn.getZ());
        config.set("parkours." + name + ".spawn.yaw", spawn.getYaw());
        config.set("parkours." + name + ".spawn.pitch", spawn.getPitch());
    }

}
