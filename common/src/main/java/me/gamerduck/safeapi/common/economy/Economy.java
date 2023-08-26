package me.gamerduck.safeapi.common.economy;

import java.util.concurrent.CompletableFuture;

public abstract class Economy<E> {

    public abstract boolean isEnabled();

    public abstract String getName();

    public abstract int fractionalDigits();

    public abstract String format(double amount);

    public abstract String currencyNamePlural();

    public abstract String currencyNameSingular();

    public abstract Boolean hasAccount(E player);
    public CompletableFuture<Boolean> hasAccountAsync(E player) {
        return CompletableFuture.supplyAsync(() -> hasAccount(player));
    }

    public abstract Double getBalance(E player);
    public CompletableFuture<Double> getBalanceAsync(E player) {
        return CompletableFuture.supplyAsync(() -> getBalance(player));
    }

    public abstract EconomyResponse setBalance(E player, double amount);
    public CompletableFuture<EconomyResponse> setBalanceAsync(E player, double amount) {
        return CompletableFuture.supplyAsync(() -> setBalance(player, amount));
    }

    public abstract Boolean has(E player, double amount);
    public CompletableFuture<Boolean> hasAsync(E player, double amount) {
        return CompletableFuture.supplyAsync(() -> has(player, amount));
    }

    public abstract EconomyResponse withdrawPlayer(E player, double amount);
    public CompletableFuture<EconomyResponse> withdrawPlayerAsync(E player, double amount) {
        return CompletableFuture.supplyAsync(() -> withdrawPlayer(player, amount));
    }

    public abstract EconomyResponse depositPlayer(E player, double amount);
    public CompletableFuture<EconomyResponse> depositPlayerAsync(E player, double amount) {
        return CompletableFuture.supplyAsync(() -> depositPlayer(player, amount));
    }

    public abstract Boolean createPlayerAccount(E player);
    public CompletableFuture<Boolean> createPlayerAccountAsync(E player) {
        return CompletableFuture.supplyAsync(() -> createPlayerAccount(player));
    }

}
