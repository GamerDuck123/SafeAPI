package me.gamerduck.safeapi.common;

import java.util.concurrent.CompletableFuture;

public interface Economy<E> {

    boolean isEnabled();

    String getName();

    int fractionalDigits();

    String format(double amount);

    String currencyNamePlural();

    String currencyNameSingular();

    CompletableFuture<Boolean> hasAccount(E player);

    CompletableFuture<Double> getBalance(E player);

    CompletableFuture<EconomyResponse> setBalance(E player, double amount);

    CompletableFuture<Boolean> has(E player, double amount);

    CompletableFuture<EconomyResponse> withdrawPlayer(E player, double amount);

    CompletableFuture<EconomyResponse> depositPlayer(E player, double amount);

    CompletableFuture<Boolean> createPlayerAccount(E player);

}
