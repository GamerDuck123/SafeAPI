package me.gamerduck.safeapi.common;

import me.gamerduck.safeapi.common.economy.Economy;
import me.gamerduck.safeapi.common.permission.Permission;

import java.io.Closeable;
import java.io.IOException;
import java.util.function.Consumer;

public class RegistrarUpdates implements Closeable {

    private Economy registeredEconomy;
    private Permission registeredPermission;
    private Consumer<RegistrarUpdates> onceUpdated;

    public static void listen(Consumer<RegistrarUpdates> onceUpdated) {
        Registrar.updateListeners.add(new RegistrarUpdates(onceUpdated));
    }

    protected RegistrarUpdates(Consumer<RegistrarUpdates> onceUpdated) {
        this.onceUpdated = onceUpdated;
    }

    protected void updateEconomy(Economy newEconomy) {
        this.registeredEconomy = newEconomy;
        onceUpdated.accept(this);
    }

    protected void updatePermission(Permission newPermission) {
        this.registeredPermission = newPermission;
        onceUpdated.accept(this);
    }

    public Economy economy() {return registeredEconomy;}
    public Permission permission() {return registeredPermission;}

    @Override
    public void close() {
        Registrar.updateListeners.remove(this);
    }
}
