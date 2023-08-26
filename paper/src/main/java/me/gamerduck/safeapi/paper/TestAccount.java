package me.gamerduck.safeapi.paper;

import com.google.common.util.concurrent.AtomicDouble;
import me.gamerduck.safeapi.common.economy.Account;
import org.bukkit.OfflinePlayer;

public class TestAccount extends Account {

    private final AtomicDouble balance;
    private final OfflinePlayer player;

    public TestAccount(OfflinePlayer player, AtomicDouble balance) {
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
