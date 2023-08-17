package me.gamerduck.safeapi.paper;

import me.gamerduck.safeapi.common.Economy;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

public interface BukkitEconomy extends Economy<OfflinePlayer> {

    public JavaPlugin plugin();

}
