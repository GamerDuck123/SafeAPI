package me.gamerduck.safeapi.nukkit;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class SafeAPI extends PluginBase {

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "Enabled SafeAPI, the new Vault replacement");
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "Disabled SafeAPI, the new Vault replacement");
    }

}
