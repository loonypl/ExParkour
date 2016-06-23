package io.github.krzysek.expk.utils;

import io.github.krzysek.expk.ExParkour;
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

}
