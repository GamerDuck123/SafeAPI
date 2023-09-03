package me.gamerduck.safeapi.paper;

import com.google.common.util.concurrent.AtomicDouble;
import org.bukkit.OfflinePlayer;

public record ExampleAccount(OfflinePlayer player, AtomicDouble balance) {

    public AtomicDouble balance(double amount) {
        balance.set(amount);
        return balance;
    }

    public void addBalance(double amount) {
        balance.addAndGet(amount);
    }

    public void subBalance(double amount) {
        balance.addAndGet(-amount);
    }

}
