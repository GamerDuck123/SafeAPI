package me.gamerduck.safeapi.paper;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.gamerduck.safeapi.common.RegistrarUpdates;
import me.gamerduck.safeapi.common.Registrar;
import me.gamerduck.safeapi.paper.economy.BukkitEconomy;
import me.gamerduck.safeapi.paper.permission.BukkitPermission;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SafeAPI extends JavaPlugin implements Listener {

    BukkitEconomy economy;
    BukkitPermission permission;

    public SafeAPI() {
        Registrar.registerEconomyProvider(new ExampleEconomy(this));
    }

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

        RegistrarUpdates.listen((listener) -> {
            economy = (BukkitEconomy) listener.economy();
            permission = (BukkitPermission) listener.permission();
        });

        Bukkit.getLogger().info(String.format("Enabled SafeAPI, the new Vault replacement"));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        economy.createOrLoadAccount(e.getPlayer());
    }

    @EventHandler
    public void onChat(AsyncChatEvent e) {
        e.getPlayer().sendMessage("Initial Balance: " + economy.balance(e.getPlayer()));
        economy.deposit(e.getPlayer(), 10);
        e.getPlayer().sendMessage("New Balance: " + economy.balance(e.getPlayer()));
    }

}
