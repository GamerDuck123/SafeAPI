package me.gamerduck.safeapi.common.permission;

public abstract class Permission<P, E, W> {

    public abstract P parent();

    public abstract String getName();

    public abstract boolean isEnabled();

    public abstract boolean hasSuperPermsCompat();

    public abstract boolean hasGroupSupport();

}
