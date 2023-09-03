package me.gamerduck.safeapi.common.permission;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public abstract class Permission<Parent, Player, W> {

    public abstract Parent parent();

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

    public abstract TriState playerHas(Player player, String permission);
    public TriState playerHas(Player player, String permission, W world) {
        return playerHas(player, permission);
    }
    public CompletableFuture<TriState> playerHasAsync(Player player, String permission) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerHas(player, permission));
    }
    public CompletableFuture<TriState> playerHasAsync(Player player, String permission, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerHas(player, permission, world));
    }

    public abstract TriState playerAdd(Player player, String permission);
    public TriState playerAdd(Player player, String permission, W world) {
        return playerAdd(player, permission);
    }
    public CompletableFuture<TriState> playerAddAsync(Player player, String permission) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerAdd(player, permission));
    }
    public CompletableFuture<TriState> playerAddAsync(Player player, String permission, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerAdd(player, permission, world));
    }

    public abstract TriState playerRemove(Player player, String permission);
    public TriState playerRemove(Player player, String permission, W world) {
        return playerRemove(player, permission);
    }
    public CompletableFuture<TriState> playerRemoveAsync(Player player, String permission) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerRemove(player, permission));
    }
    public CompletableFuture<TriState> playerRemoveAsync(Player player, String permission, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerRemove(player, permission, world));
    }

    public abstract TriState playerSetPrimaryGroup(Player player, String group);
    public TriState playerSetPrimaryGroup(Player player, String group, W world) {
        return playerSetPrimaryGroup(player, group);
    }
    public CompletableFuture<TriState> playerSetPrimaryGroupAsync(Player player, String group) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerSetPrimaryGroup(player, group));
    }
    public CompletableFuture<TriState> playerSetPrimaryGroupAsync(Player player, String group, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerSetPrimaryGroup(player, group, world));
    }

    public abstract TriState playerAddGroup(Player player, String group);
    public TriState playerAddGroup(Player player, String group, W world) {
        return playerAddGroup(player, group);
    }
    public CompletableFuture<TriState> playerAddGroupAsync(Player player, String group) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerAddGroup(player, group));
    }
    public CompletableFuture<TriState> playerAddGroupAsync(Player player, String group, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerAddGroup(player, group, world));
    }

    public abstract TriState playerRemoveGroup(Player player, String group);
    public TriState playerRemoveGroup(Player player, String group, W world) {
        return playerRemoveGroup(player, group);
    }
    public CompletableFuture<TriState> playerRemoveGroupAsync(Player player, String group) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerRemoveGroup(player, group));
    }
    public CompletableFuture<TriState> playerRemoveGroupAsync(Player player, String group, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> playerRemoveGroup(player, group, world));
    }

    public abstract Set<String> getPlayerGroups(Player player);
    public Set<String> getPlayerGroups(Player player, W world) {
        return getPlayerGroups(player);
    }
    public CompletableFuture<Set<String>> getPlayerGroupsAsync(Player player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerGroups(player));
    }
    public CompletableFuture<Set<String>> getPlayerGroupsAsync(Player player, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerGroups(player, world));
    }

    public abstract String getPlayerPrimaryGroup(Player player);
    public String getPlayerPrimaryGroup(Player player, W world) {
        return getPlayerPrimaryGroup(player);
    }
    public CompletableFuture<String> getPlayerPrimaryGroupAsync(Player player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrimaryGroup(player));
    }
    public CompletableFuture<String> getPlayerPrimaryGroupAsync(Player player, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrimaryGroup(player, world));
    }

    public abstract String getPlayerPrefix(Player player);
    public String getPlayerPrefix(Player player, W world) {
        return getPlayerPrefix(player);
    }
    public CompletableFuture<String> getPlayerPrefixAsync(Player player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrefix(player));
    }
    public CompletableFuture<String> getPlayerPrefixAsync(Player player, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrefix(player, world));
    }

    public abstract String setPlayerPrefix(Player player, String prefix);
    public String setPlayerPrefix(Player player, String prefix, W world) {
        return setPlayerPrefix(player, prefix);
    }
    public CompletableFuture<String> setPlayerPrefixAsync(Player player, String prefix) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setPlayerPrefix(player, prefix));
    }
    public CompletableFuture<String> getPlayerPrefixAsync(Player player, String prefix, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setPlayerPrefix(player, prefix, world));
    }

    public abstract String getPlayerSuffix(Player player);
    public String getPlayerSuffix(Player player, W world) {
        return getPlayerSuffix(player);
    }
    public CompletableFuture<String> getPlayerSuffixAsync(Player player) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrefix(player));
    }
    public CompletableFuture<String> getPlayerSuffixAsync(Player player, W world) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> getPlayerPrefix(player, world));
    }

    public abstract String setPlayerSuffix(Player player, String suffix);
    public String setPlayerSuffix(Player player, String prefix, W world) {
        return setPlayerSuffix(player, prefix);
    }
    public CompletableFuture<String> setPlayerSuffixAsync(Player player, String prefix) {
        if (!allowAsync()) throw new IllegalStateException("Asynchronous operations are not supported");
        return CompletableFuture.supplyAsync(() -> setPlayerSuffix(player, prefix));
    }
    public CompletableFuture<String> getPlayerSuffixAsync(Player player, String prefix, W world) {
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
