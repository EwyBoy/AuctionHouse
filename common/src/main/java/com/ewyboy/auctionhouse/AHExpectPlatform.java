package com.ewyboy.auctionhouse;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class AHExpectPlatform {

    /**
     * @return The path to the game directory of the current platform
     */
    @ExpectPlatform
    public static Path getGameDir() {
        throw new AssertionError("Platform#getGameDir() was not remapped");
    }

    /**
     * @return The path to the game directory of the current platform
     */
    @ExpectPlatform
    public static Path getConfigDir() {
        throw new AssertionError("Platform#getConfigDir() was not remapped");
    }

}
