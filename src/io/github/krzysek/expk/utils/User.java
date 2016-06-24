package io.github.krzysek.expk.utils;

import io.github.krzysek.expk.ExParkour;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.UUID;

public class User {

    protected UUID uuid;
    protected final FileConfiguration players = new ExParkour().getConfig(ExParkour.cType.PLAYERS);

    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public int getStartedParkours() {
        return this.players.getInt("byUUID." + this.uuid + ".parkours.started");
    }

    public int getFinishedParkours() {
        return this.players.getInt("byUUID." + this.uuid + ".parkours.finished");
    }

    public int getPoints() {
        return this.players.getInt("byUUID." + this.uuid + ".rank.points");
    }

    public String getStatus() {
        return this.players.getString("byUUID." + this.uuid + ".rank.status");
    }

    public void setStartedParkours(int num) {
        this.players.set("byUUID." + this.uuid + ".parkours.started", num);
    }

    public void setFinishedParkours(int num) {
        this.players.set("byUUID." + this.uuid + ".parkours.finished", num);
    }

    public void setPoints(int num) {
        this.players.set("byUUID." + this.uuid + ".rank.points", num);
    }

    public void setStatus(String status) {
        this.players.set("byUUID." + this.uuid + ".rank.status", status);
    }

    public String getName() {
        return Bukkit.getPlayer(this.uuid).getName();
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public void register() {
        this.players.set("byUUID." + getUUID() + ".name", getName());
        this.players.set("byUUID." + getUUID() + ".parkours.started", 0);
        this.players.set("byUUID." + getUUID() + ".parkours.finished", 0);
        this.players.set("byUUID." + getUUID() + ".rank.points", 0);
        this.players.set("byUUID." + getUUID() + ".rank.status", "newbie" /* TODO: getting rank for 0 points */);
    }

    public boolean isRegistered() {
        return this.players.contains("byUUID." + getUUID());
    }

}
