package me.gamerduck.safeapi.paper;

import com.google.common.util.concurrent.AtomicDouble;
import org.bukkit.OfflinePlayer;

public class ExampleAccount {

    private final AtomicDouble balance;
    private final OfflinePlayer player;

    public ExampleAccount(OfflinePlayer player, AtomicDouble balance) {
        this.player = player;
        this.balance = balance;
    }

    public OfflinePlayer player() {return player;}
    public AtomicDouble balance() {return balance;}
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
