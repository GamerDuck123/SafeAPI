package me.gamerduck.safeapi.common.economy;

import java.util.concurrent.CompletableFuture;

public abstract class Economy<P, E> {

    public abstract P parent();

    public abstract boolean enabled();

    public abstract String name();

    public abstract String format(double amount);

    public abstract String currencyPlural();

    public abstract String currencySingular();

    public boolean allowAsync() {
        return true;
    }

    public abstract Boolean hasAccount(E player);
    public CompletableFuture<Boolean> hasAccountAsync(E player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> hasAccount(player));
    }

    public abstract Double balance(E player);
    public CompletableFuture<Double> balanceAsync(E player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> balance(player));
    }

    public abstract Response balance(E player, double amount);
    public CompletableFuture<Response> balanceAsync(E player, double amount) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> balance(player, amount));
    }

    public abstract Boolean has(E player, double amount);
    public CompletableFuture<Boolean> hasAsync(E player, double amount) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> has(player, amount));
    }

    public abstract Response withdraw(E player, double amount);
    public CompletableFuture<Response> withdrawAsync(E player, double amount) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> withdraw(player, amount));
    }

    public abstract Response deposit(E player, double amount);
    public CompletableFuture<Response> depositAsync(E player, double amount) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> deposit(player, amount));
    }

    public abstract <A extends Account> A createAccount(E player);
    public <A extends Account> CompletableFuture<A> createAccountAsync(E player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> createAccount(player));
    }

    public abstract <A extends Account> A getAccount(E player);
    public <A extends Account> CompletableFuture<A> getAccountAsync(E player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getAccount(player));
    }

    public record Response(double amount, double balance,
                                  Type type, String errorMessage) {

        public enum Type {
            NOT_IMPLEMENTED(0),
            SUCCESS(1),
            FAILURE(2),
            ;

            private int id;

            Type(int id) {
                this.id = id;
            }

            int getId() {
                return id;
            }
        }

        public boolean success() {
            return type == Type.SUCCESS;
        }

        public boolean failure() {
            return type == Type.FAILURE;
        }
    }
}
