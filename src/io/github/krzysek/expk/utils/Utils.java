package io.github.krzysek.expk.utils;

import io.github.krzysek.expk.ExParkour;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Utils {

    protected Player player;

    public Utils(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public UUID getUUID() {
        return this.player.getUniqueId();
    }

    public void send(String text) {
        this.player.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }

    public void config(ExParkour.cType type, String path) {
        this.player.sendMessage(ChatColor.translateAlternateColorCodes('&', ChatColor.GOLD + "˟ " + new ExParkour().getConfig(type).getString(path)));
    }

}
