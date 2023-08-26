package me.gamerduck.safeapi.paper.economy;

import me.gamerduck.safeapi.common.economy.Economy;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class BukkitEconomy extends Economy<Plugin, OfflinePlayer> {

    public abstract JavaPlugin plugin();

}
