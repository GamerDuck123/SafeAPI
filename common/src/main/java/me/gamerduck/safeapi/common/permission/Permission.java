package me.gamerduck.safeapi.common.permission;

import me.gamerduck.safeapi.common.TriState;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public abstract class Permission<P, E, W> {

    public abstract P parent();

    public abstract boolean enabled();

    public abstract String name();

    public abstract boolean groupSupport();

    public boolean allowAsync() {
        return true;
    }


    /**
     *
     *  PLAYERS
     *
     */

    public abstract TriState playerHas(E player, String permission);
    public TriState playerHas(E player, String permission, W world) {
        return playerHas(player, permission);
    }
    public CompletableFuture<TriState> playerHasAsync(E player, String permission) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerHas(player, permission));
    }
    public CompletableFuture<TriState> playerHasAsync(E player, String permission, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerHas(player, permission, world));
    }

    public abstract TriState playerAdd(E player, String permission);
    public TriState playerAdd(E player, String permission, W world) {
        return playerAdd(player, permission);
    }
    public CompletableFuture<TriState> playerAddAsync(E player, String permission) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerAdd(player, permission));
    }
    public CompletableFuture<TriState> playerAddAsync(E player, String permission, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerAdd(player, permission, world));
    }

    public abstract TriState playerRemove(E player, String permission);
    public TriState playerRemove(E player, String permission, W world) {
        return playerRemove(player, permission);
    }
    public CompletableFuture<TriState> playerRemoveAsync(E player, String permission) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerRemove(player, permission));
    }
    public CompletableFuture<TriState> playerRemoveAsync(E player, String permission, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerRemove(player, permission, world));
    }

    public abstract TriState playerSetPrimaryGroup(E player, String group);
    public TriState playerSetPrimaryGroup(E player, String group, W world) {
        return playerSetPrimaryGroup(player, group);
    }
    public CompletableFuture<TriState> playerSetPrimaryGroupAsync(E player, String group) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerSetPrimaryGroup(player, group));
    }
    public CompletableFuture<TriState> playerSetPrimaryGroupAsync(E player, String group, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerSetPrimaryGroup(player, group, world));
    }

    public abstract TriState playerAddGroup(E player, String group);
    public TriState playerAddGroup(E player, String group, W world) {
        return playerAddGroup(player, group);
    }
    public CompletableFuture<TriState> playerAddGroupAsync(E player, String group) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerAddGroup(player, group));
    }
    public CompletableFuture<TriState> playerAddGroupAsync(E player, String group, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerAddGroup(player, group, world));
    }

    public abstract TriState playerRemoveGroup(E player, String group);
    public TriState playerRemoveGroup(E player, String group, W world) {
        return playerRemoveGroup(player, group);
    }
    public CompletableFuture<TriState> playerRemoveGroupAsync(E player, String group) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerRemoveGroup(player, group));
    }
    public CompletableFuture<TriState> playerRemoveGroupAsync(E player, String group, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerRemoveGroup(player, group, world));
    }

    public abstract Set<String> getPlayerGroups(E player);
    public Set<String> getPlayerGroups(E player, W world) {
        return getPlayerGroups(player);
    }
    public CompletableFuture<Set<String>> getPlayerGroupsAsync(E player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerGroups(player));
    }
    public CompletableFuture<Set<String>> getPlayerGroupsAsync(E player, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerGroups(player, world));
    }

    public abstract String getPlayerPrimaryGroup(E player);
    public String getPlayerPrimaryGroup(E player, W world) {
        return getPlayerPrimaryGroup(player);
    }
    public CompletableFuture<String> getPlayerPrimaryGroupAsync(E player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrimaryGroup(player));
    }
    public CompletableFuture<String> getPlayerPrimaryGroupAsync(E player, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrimaryGroup(player, world));
    }

    public abstract String getPlayerPrefix(E player);
    public String getPlayerPrefix(E player, W world) {
        return getPlayerPrefix(player);
    }
    public CompletableFuture<String> getPlayerPrefixAsync(E player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrefix(player));
    }
    public CompletableFuture<String> getPlayerPrefixAsync(E player, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrefix(player, world));
    }

    public abstract String setPlayerPrefix(E player, String prefix);
    public String setPlayerPrefix(E player, String prefix, W world) {
        return setPlayerPrefix(player, prefix);
    }
    public CompletableFuture<String> setPlayerPrefixAsync(E player, String prefix) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setPlayerPrefix(player, prefix));
    }
    public CompletableFuture<String> getPlayerPrefixAsync(E player, String prefix, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setPlayerPrefix(player, prefix, world));
    }

    public abstract String getPlayerSuffix(E player);
    public String getPlayerSuffix(E player, W world) {
        return getPlayerSuffix(player);
    }
    public CompletableFuture<String> getPlayerSuffixAsync(E player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrefix(player));
    }
    public CompletableFuture<String> getPlayerSuffixAsync(E player, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrefix(player, world));
    }

    public abstract String setPlayerSuffix(E player, String suffix);
    public String setPlayerSuffix(E player, String prefix, W world) {
        return setPlayerSuffix(player, prefix);
    }
    public CompletableFuture<String> setPlayerSuffixAsync(E player, String prefix) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setPlayerSuffix(player, prefix));
    }
    public CompletableFuture<String> getPlayerSuffixAsync(E player, String prefix, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setPlayerSuffix(player, prefix, world));
    }

    /**
     *
     *  GROUPS
     *
     */
    public abstract TriState groupHas(String group, String permission);
    public TriState groupHas(String group, String permission, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        return groupHas(group, permission);
    }
    public CompletableFuture<TriState> groupHasAsync(String group, String permission) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> groupHas(group, permission));
    }
    public CompletableFuture<TriState> groupHasAsync(String group, String permission, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> groupHas(group, permission, world));
    }

    public abstract TriState groupAdd(String group, String permission);
    public TriState groupAdd(String group, String permission, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        return groupAdd(group, permission);
    }
    public CompletableFuture<TriState> playerAddAsync(String group, String permission) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> groupAdd(group, permission));
    }
    public CompletableFuture<TriState> playerAddAsync(String group, String permission, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> groupAdd(group, permission, world));
    }

    public abstract TriState groupRemove(String group, String permission);
    public TriState groupRemove(String group, String permission, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        return groupRemove(group, permission);
    }
    public CompletableFuture<TriState> groupRemoveAsync(String group, String permission) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> groupRemove(group, permission));
    }
    public CompletableFuture<TriState> groupRemoveAsync(String group, String permission, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> groupRemove(group, permission, world));
    }

    public abstract String getGroupPrefix(String group);
    public String getGroupPrefix(String group, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        return getGroupPrefix(group);
    }
    public CompletableFuture<String> getGroupPrefixAsync(String group) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getGroupPrefix(group));
    }
    public CompletableFuture<String> getGroupPrefixAsync(String group, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getGroupPrefix(group, world));
    }

    public abstract String setGroupPrefix(String group, String prefix);
    public String setGroupPrefix(String group, String prefix, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        return setGroupPrefix(group, prefix);
    }
    public CompletableFuture<String> setGroupPrefixAsync(String group, String prefix) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setGroupPrefix(group, prefix));
    }
    public CompletableFuture<String> setGroupPrefixAsync(String group, String prefix, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setGroupPrefix(group, prefix, world));
    }

    public abstract String getGroupSuffix(String group);
    public String getGroupSuffix(String group, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        return getGroupSuffix(group);
    }
    public CompletableFuture<String> getGroupSuffixAsync(String group) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getGroupSuffix(group));
    }
    public CompletableFuture<String> getGroupSuffixAsync(String group, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getGroupSuffix(group, world));
    }

    public abstract String setGroupSuffix(String group, String suffix);
    public String setGroupSuffix(String group, String suffix, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        return setGroupSuffix(group, suffix);
    }
    public CompletableFuture<String> setGroupSuffixAsync(String group, String suffix) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setGroupSuffix(group, suffix));
    }
    public CompletableFuture<String> setGroupSuffixAsync(String group, String suffix, W world) {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setGroupSuffix(group, suffix, world));
    }

    public abstract Set<String> getGroups();
    public CompletableFuture<Set<String>> getGroupsAsync() {
        if (!groupSupport()) throw new IllegalStateException("Groups are not supported");
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getGroups());
    }
}
