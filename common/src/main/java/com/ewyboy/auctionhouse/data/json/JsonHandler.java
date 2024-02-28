package com.ewyboy.auctionhouse.data.json;

import com.ewyboy.auctionhouse.platform.AHExpectPlatform;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class JsonHandler {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static final File JSON_DIR = new File(AHExpectPlatform.getConfigDir().toFile(), "auctionhouse");

}
