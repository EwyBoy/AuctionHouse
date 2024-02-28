package com.ewyboy.auctionhouse.forge.platform;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class AHExpectPlatform {

    /**
     * @return The path to the Forge game directory
     */
    public static Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }

    /**
     * @return The path to the Forge config directory
     */
    public static Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }

}
