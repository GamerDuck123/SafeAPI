package me.gamerduck.safeapi.paper;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.AtomicDouble;
import me.gamerduck.safeapi.paper.economy.BukkitEconomy;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class ExampleEconomy extends BukkitEconomy {

    public final HashMap<UUID, ExampleAccount> cache = Maps.newHashMap();

    private final JavaPlugin parent;
    private boolean enabled = false;

    public ExampleEconomy(JavaPlugin parent) {
        this.parent = parent;
        this.enabled = true;
    }

    @Override
    public Plugin parent() {
        return parent;
    }

    @Override
    public boolean enabled() {
        return enabled;
    }

    @Override
    public String name() {
        return "Test Economy";
    }

    @Override
    public String format(double amount) {
        return String.valueOf(amount);
    }

    @Override
    public String currencyPlural() {
        return "Dollars";
    }

    @Override
    public String currencySingular() {
        return "Dollar";
    }

    @Override
    public Boolean hasAccount(OfflinePlayer player) {
        return cache.containsKey(player.getUniqueId());
    }

    @Override
    public Double balance(OfflinePlayer player) {
        return cache.get(player.getUniqueId()).balance().get();
    }

    @Override
    public Response balance(OfflinePlayer player, double amount) {
        ExampleAccount account = cache.get(player.getUniqueId());
        account.balance(amount);
        return new Response(amount, account.balance().get(), Response.Type.SUCCESS, null);
    }

    @Override
    public Boolean has(OfflinePlayer player, double amount) {
        ExampleAccount account = cache.get(player.getUniqueId());
        return account.balance().get() >= amount;
    }

    @Override
    public Response withdraw(OfflinePlayer player, double amount) {
        ExampleAccount account = cache.get(player.getUniqueId());
        if (amount < 0) return new Response(0, 0, Response.Type.FAILURE, "Cannot withdraw negative funds");
        if (account.balance().get() < amount) return new Response(0, account.balance().get(), Response.Type.FAILURE, "Insufficient funds");
        account.balance(account.balance().get() - amount);
        return new Response(amount, account.balance().get(), Response.Type.SUCCESS, null);
    }

    @Override
    public Response deposit(OfflinePlayer player, double amount) {
        if (amount < 0) return new Response(0, 0, Response.Type.FAILURE, "Cannot deposit negative funds");
        ExampleAccount account = cache.get(player.getUniqueId());
        account.balance().addAndGet(amount);
        return new Response(amount, account.balance().get(), Response.Type.SUCCESS, null);
    }

    @Override
    public Boolean createAccount(OfflinePlayer player) {
        cache.put(player.getUniqueId(), new ExampleAccount(player, new AtomicDouble(100.0)));
        return cache.containsKey(player.getUniqueId());
    }

    @Override
    public Boolean loadAccount(OfflinePlayer player) {
        cache.put(player.getUniqueId(), new ExampleAccount(player, new AtomicDouble(100.0)));
        return cache.containsKey(player.getUniqueId());
    }

}
