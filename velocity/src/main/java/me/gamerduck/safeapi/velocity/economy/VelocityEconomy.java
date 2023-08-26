package me.gamerduck.safeapi.velocity.economy;

import com.velocitypowered.api.plugin.PluginContainer;
import com.velocitypowered.api.proxy.Player;
import me.gamerduck.safeapi.common.economy.Economy;

public abstract class VelocityEconomy extends Economy<Player> {

    public abstract PluginContainer plugin();

}
