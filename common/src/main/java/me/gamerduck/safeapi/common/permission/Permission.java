package me.gamerduck.safeapi.common.permission;

public abstract class Permission<E, W> {

    abstract public String getName();

    abstract public boolean isEnabled();

    abstract public boolean hasSuperPermsCompat();

    abstract public boolean hasGroupSupport();

}
