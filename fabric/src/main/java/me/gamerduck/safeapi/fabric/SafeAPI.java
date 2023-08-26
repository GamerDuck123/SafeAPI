package me.gamerduck.safeapi.fabric;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SafeAPI implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("safeapi");

    @Override
    public void onInitialize() {
        LOGGER.info(String.format("Enabled SafeAPI, the new Vault replacement"));
    }
}