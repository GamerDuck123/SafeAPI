package me.gamerduck.safeapi.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(id = "safeapi", name = "SafeAPI", version = "1.0-SNAPSHOT",
        url = "https://example.org", description = "I did it!", authors = {"GamerDuck123"})
public class SafeAPI {

    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public SafeAPI(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;

        logger.info(String.format("Enabled SafeAPI, the new Vault replacement"));
    }
}
