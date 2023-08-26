package me.gamerduck.safeapi.paper;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SafeAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info(String.format("Enabled SafeAPI, the new Vault replacement"));
    }
}
