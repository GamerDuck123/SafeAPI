package me.gamerduck.safeapi.common;

import me.gamerduck.safeapi.common.economy.Economy;
import me.gamerduck.safeapi.common.permission.Permission;

import java.util.ArrayList;
import java.util.List;

public class Registrar {

    protected static List<RegistrarUpdates> updateListeners = new ArrayList<>();

    private static Economy economyProvider;
    private static Boolean economyRegistrable;
    private static Permission permissionProvider;
    private static Boolean permissionRegistrable;

    public static void registerEconomyProvider(Economy eco, Boolean canReplace) {
        if (economyProvider != null && !economyRegistrable) throw new IllegalStateException("The Economy Provider has already been registered and cannot be overridden");
        economyProvider = eco;
        economyRegistrable = canReplace;
        updateListeners.forEach(listener -> {
            listener.updateEconomy(economyProvider);
            if (!economyRegistrable) listener.close();
        });
    }

    public static void registerEconomyProvider(Economy eco) {
        registerEconomyProvider(eco, false);
    }

    public static void registerPermissionProvider(Permission perms, Boolean canReplace) {
        if (permissionProvider != null && !permissionRegistrable) throw new IllegalStateException("The Permission Provider has already been registered and cannot be overridden");
        permissionProvider = perms;
        permissionRegistrable = canReplace;
        updateListeners.forEach(listener -> {
            listener.updatePermission(permissionProvider);
            if (!permissionRegistrable) listener.close();
        });
    }

    public static void registerPermissionProvider(Permission perms) {
        registerPermissionProvider(perms, false);
    }
}
