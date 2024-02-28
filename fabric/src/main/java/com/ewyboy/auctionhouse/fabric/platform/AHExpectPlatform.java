package com.ewyboy.auctionhouse.fabric.platform;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class AHExpectPlatform {

    /**
     * @return The path to the Fabric game directory
     */
    public static Path getGameDir() {
        return FabricLoader.getInstance().getGameDir();
    }

    /**
     * @return The path to the Fabric config directory
     */
    public static Path getConfigDir() {
        return FabricLoader.getInstance().getConfigDir();
    }

}
