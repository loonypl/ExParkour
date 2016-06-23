package io.github.krzysek.expk.utils;

import io.github.krzysek.expk.ExParkour;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class Lobby {

    protected final FileConfiguration parkours = new ExParkour().getConfig(ExParkour.cType.PARKOURS);

    public Lobby() {}

    public void setLocation(Location location) {
        this.parkours.set("lobby.x", location.getX());
        this.parkours.set("lobby.y", location.getY());
        this.parkours.set("lobby.z", location.getZ());
        this.parkours.set("lobby.world", location.getWorld().getName());
        this.parkours.set("lobby.yaw", location.getYaw());
        this.parkours.set("lobby.pitch", location.getPitch());
    }

    public Location getLocation() {
        return new Location(Bukkit.getWorld(this.parkours.getString("lobby.world")), this.parkours.getDouble("lobby.x"), this.parkours.getDouble("lobby.y"), this.parkours.getDouble("lobby.z"), Float.parseFloat(this.parkours.getString("lobby.yaw")), Float.parseFloat(this.parkours.getString("lobby.pitch")));
    }

    public World getWorld() {
        return Bukkit.getWorld(this.parkours.getString("lobby.world"));
    }

    public Double getX() {
        return this.parkours.getDouble("lobby.x");
    }

    public Double getY() {
        return this.parkours.getDouble("lobby.y");
    }

    public Double getZ() {
        return this.parkours.getDouble("lobby.z");
    }

    public Float getYaw() {
        return Float.parseFloat(this.parkours.getString("lobby.yaw"));
    }

    public Float getPitch() {
        return Float.parseFloat(this.parkours.getString("lobby.pitch"));
    }

}
