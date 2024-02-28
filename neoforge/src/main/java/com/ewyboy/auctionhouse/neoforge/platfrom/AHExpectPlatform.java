package com.ewyboy.auctionhouse.neoforge.platfrom;

import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class AHExpectPlatform {

    /**
     * @return The path to the Neoforge game directory
     */
    public static Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }

    /**
     * @return The path to the Neoforge config directory
     */
    public static Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }

}