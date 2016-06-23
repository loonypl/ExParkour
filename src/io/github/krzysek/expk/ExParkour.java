package io.github.krzysek.expk;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExParkour extends JavaPlugin {

    protected final FileConfiguration config = new YamlConfiguration();
    protected final FileConfiguration parkours = new YamlConfiguration();
    protected final FileConfiguration players = new YamlConfiguration();
    protected final File configFile = new File(getDataFolder(), "config.yml");
    protected final File parkoursFile = new File(getDataFolder(), "parkours.yml");
    protected final File playersFile = new File(getDataFolder(), "players.yml");
    protected ExParkour plugin;

    @Override
    public void onLoad() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        initConfigs();
        loadConfigs();
        saveConfigs();
        initMetrics();
    }

    @Override
    public void onDisable() {
        saveConfigs();
    }

    public ExParkour() {}

    public ExParkour getPlugin() {
        return plugin;
    }

    protected void initMetrics() {
        if(config.getBoolean("metrics")) {
            try {
                new Metrics(this).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void initConfigs() {
        try {
            if(!(configFile.exists())) {
                configFile.getParentFile().mkdirs();
                copy(getResource("config.yml"), configFile);
            }
            if(!(parkoursFile.exists())) {
                parkoursFile.getParentFile().mkdirs();
                copy(getResource("parkours.yml"), parkoursFile);
            }
            if(!(playersFile.exists())) {
                playersFile.getParentFile().mkdirs();
                copy(getResource("players.yml"), playersFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void copy(InputStream in, File file) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len = in.read(buf)) > 0)
                out.write(buf, 0, len);
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadConfigs() {
        try {
            config.load(configFile);
            parkours.load(parkoursFile);
            players.load(playersFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void saveConfigs() {
        try {
            config.save(configFile);
            parkours.save(parkoursFile);
            players.save(playersFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public enum cType {
        CONFIG, PARKOURS, PLAYERS
    }

    public FileConfiguration getConfig(cType type) {
        if(type == cType.CONFIG) return config;
        else if(type == cType.PARKOURS) return parkours;
        else if(type == cType.PLAYERS) return players;
        return null;
    }

}
