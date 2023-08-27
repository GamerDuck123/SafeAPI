package me.gamerduck.safeapi.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

public class SafeAPI {
    @Inject
    public SafeAPI(ProxyServer server, Logger logger) {
        logger.info(String.format("Enabled SafeAPI, the new Vault replacement"));
    }
}
