package io.github.krzysek.expk.utils;

import io.github.krzysek.expk.ExParkour;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.List;

public class Rank {

    protected HashMap<String, Integer> ranks = new HashMap<>();
    protected final FileConfiguration config = new ExParkour().getConfig(ExParkour.cType.CONFIG);
    protected final List<String> _ranks = config.getStringList("ranks");

    public Rank() {
        for(int i = 0;i != _ranks.size();i++) {
            ranks.put(_ranks.get(i), config.getInt("ranks." + _ranks.get(i)));
        }
    }

    public String byPoints(int points) {
        for(int i = 0;i != _ranks.size();i++) {
            if(ranks.get(_ranks.get(i)) == points) {
                return _ranks.get(i);
            }
        }
        return null;
    }

}
