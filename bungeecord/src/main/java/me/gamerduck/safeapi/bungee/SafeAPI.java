package me.gamerduck.safeapi.bungee;

import me.gamerduck.safeapi.common.RegisteredServices;
import net.md_5.bungee.api.plugin.Plugin;

public class SafeAPI extends Plugin {

    @Override
    public void onEnable() {
        getLogger().info(String.format("Enabled SafeAPI, the new Vault replacement"));
    }
}
