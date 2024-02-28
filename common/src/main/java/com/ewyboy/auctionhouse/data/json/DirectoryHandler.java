package com.ewyboy.auctionhouse.data.json;

import com.ewyboy.auctionhouse.AuctionHouse;
import com.ewyboy.auctionhouse.AHExpectPlatform;
import com.ewyboy.auctionhouse.util.ModLogger;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryHandler {

    public static final Path CONFIG_DIR = Paths.get(AHExpectPlatform.getConfigDir().toAbsolutePath().toString(), AuctionHouse.MOD_ID);
    public static final Path Game_DIR = Paths.get(AHExpectPlatform.getGameDir().toAbsolutePath().toString(), AuctionHouse.MOD_ID);

    public static void init() {
        createDirectory(CONFIG_DIR);
        createDirectory(Game_DIR);
    }

    private static void createDirectory(Path path) {
        try {
            ModLogger.info("Creating directory :: " + path);
            Files.createDirectory(path);
        }
        catch (FileAlreadyExistsException ignored) {}
        catch (IOException e) {
            ModLogger.error("Failed to create directory :: " + path, e);
        }
    }

}
