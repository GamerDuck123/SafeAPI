package me.gamerduck.safeapi.bungee;

import net.md_5.bungee.api.plugin.Plugin;

public class SafeAPI extends Plugin {

    @Override
    public void onEnable() {
        getLogger().info(String.format("Enabled SafeAPI, the new Vault replacement"));
    }
}
