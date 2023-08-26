package me.gamerduck.safeapi.common;

import me.gamerduck.safeapi.common.economy.Economy;
import me.gamerduck.safeapi.common.permission.Permission;

public class RegisteredServices {

    private static Economy economyProvider;
    private static Permission permissionProvider;

    public static Economy getEconomyProvider() {
        if (economyProvider == null) throw new NullPointerException("No Economy Provider has been set");
        return economyProvider;
    }

    public static void setEconomyProvider(Economy eco) {
        if (economyProvider != null) throw new IllegalStateException("The Economy Provider has already been set");
        economyProvider = eco;
    }

    public static Permission getPermissionProvider() {
        if (permissionProvider == null) throw new NullPointerException("No Permission Provider has been set");
        return permissionProvider;
    }

    public static void setPermissionProvider(Permission perms) {
        if (permissionProvider != null) throw new IllegalStateException("The Permission Provider has already been set");
        permissionProvider = perms;
    }

}
