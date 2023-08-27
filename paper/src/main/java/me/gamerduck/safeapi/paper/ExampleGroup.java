package me.gamerduck.safeapi.paper;

import org.bukkit.permissions.Permission;

import java.util.HashSet;
import java.util.Set;

public class ExampleGroup {
    private final String name;
    private String prefix;
    private String suffix;
    private Set<Permission> permissions = new HashSet<>();

    public ExampleGroup(String name, String prefix, String suffix) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String name() {return name;}
    public String prefix() {return prefix;}
    public String prefix(String prefix) {return this.prefix = prefix;}
    public String suffix() {return suffix;}
    public String suffix(String suffix) {return this.suffix = suffix;}
    public Set<Permission> permissions() {return permissions;}
    public Set<Permission> permission(Permission permission) {
        permissions.add(permission);
        return permissions;
    }

}
