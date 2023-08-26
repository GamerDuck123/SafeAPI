package me.gamerduck.safeapi.paper;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SafeAPI extends JavaPlugin {
    private static Logger log;

    @Override
    public void onEnable() {
        log = this.getLogger();
        log.info(String.format("Enabled Version %s", getDescription().getVersion()));
    }
}
