package me.gamerduck.safeapi.paper;

import me.gamerduck.safeapi.paper.permission.BukkitPermission;
import org.bukkit.OfflinePlayer;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class ExamplePermission extends BukkitPermission {

    public HashMap<UUID, Set<String>> playerPermissions = new HashMap<>();
    public HashMap<UUID, Set<String>> playerGroups = new HashMap<>();
    public HashMap<UUID, String> playerPrimaryGroup = new HashMap<>();
    public Set<String> groups;

    private final JavaPlugin parent;
    private boolean enabled = false;

    public ExamplePermission(JavaPlugin parent) {
        this.parent = parent;
        this.enabled = true;
    }

    @Override
    public Plugin parent() {
        return parent;
    }

    @Override
    public boolean enabled() {
        return enabled;
    }

    @Override
    public String name() {
        return "Test Permissions";
    }

    @Override
    public boolean groupSupport() {
        return false;
    }

    @Override
    public Boolean playerHas(OfflinePlayer player, String permission) {
        return playerPermissions.get(player.getUniqueId()).contains(permission);
    }

    @Override
    public Boolean playerAdd(OfflinePlayer player, String permission) {
        if (playerHas(player, permission)) return true;
        return playerPermissions.get(player.getUniqueId()).add(permission);
    }

    @Override
    public Boolean playerRemove(OfflinePlayer player, String permission) {
        if (!playerHas(player, permission)) return true;
        return playerPermissions.get(player.getUniqueId()).remove(permission);
    }

    @Override
    public Boolean playerSetPrimaryGroup(OfflinePlayer player, String group) {
        if (getPlayerPrimaryGroup(player).equalsIgnoreCase(group)) return true;
        playerPrimaryGroup.put(player.getUniqueId(), group);
        return playerPrimaryGroup.get(player.getUniqueId()).equals(group);
    }

    @Override
    public Boolean playerAddGroup(OfflinePlayer player, String group) {
        if (getPlayerGroups(player).contains(group)) return true;
        return playerGroups.get(player.getUniqueId()).add(group);
    }

    @Override
    public Boolean playerRemoveGroup(OfflinePlayer player, String group) {
        if (!getPlayerGroups(player).contains(group)) return true;
        return playerGroups.get(player.getUniqueId()).remove(group);
    }

    @Override
    public Set<String> getPlayerGroups(OfflinePlayer player) {
        return playerGroups.get(player.getUniqueId());
    }

    @Override
    public String getPlayerPrimaryGroup(OfflinePlayer player) {
        return playerPrimaryGroup.get(player.getUniqueId());
    }

    @Override
    public String getPlayerPrefix(OfflinePlayer player) {
        return getPlayerPrimaryGroup(player);
    }

    @Override
    public String setPlayerPrefix(OfflinePlayer player, String prefix) {
        return getPlayerPrimaryGroup(player);
    }

    @Override
    public String getPlayerSuffix(OfflinePlayer player) {
        return getPlayerPrimaryGroup(player);
    }

    @Override
    public String setPlayerSuffix(OfflinePlayer player, String suffix) {
        return getPlayerPrimaryGroup(player);
    }

    @Override
    public Boolean groupHas(String group, String permission) {
        return null;
    }

    @Override
    public Boolean groupAdd(String group, String permission) {
        return null;
    }

    @Override
    public Boolean groupRemove(String group, String permission) {
        return null;
    }

    @Override
    public String getGroupPrefix(String group) {
        return null;
    }

    @Override
    public String setGroupPrefix(String group, String prefix) {
        return null;
    }

    @Override
    public String getGroupSuffix(String group) {
        return null;
    }

    @Override
    public String setGroupSuffix(String group, String suffix) {
        return null;
    }

    @Override
    public Set<String> getGroups() {
        return groups;
    }
}
