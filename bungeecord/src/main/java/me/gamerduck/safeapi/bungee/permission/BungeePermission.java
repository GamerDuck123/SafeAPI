package me.gamerduck.safeapi.bungee.permission;

import me.gamerduck.safeapi.common.permission.Permission;
import net.md_5.bungee.api.connection.ConnectedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Plugin;

public abstract class BungeePermission extends Permission<Plugin, ConnectedPlayer, Server> {
}
