package me.gamerduck.safeapi.common;

import me.gamerduck.safeapi.common.economy.Economy;

public class RegisteredServices {

    private static Economy economyProvider;

    public static Economy getEconomyProvider() {
        return economyProvider;
    }

    public static void setEconomyProvider(Economy eco) {
        economyProvider = eco;
    }

}
