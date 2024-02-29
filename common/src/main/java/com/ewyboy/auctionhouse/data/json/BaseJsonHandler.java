package com.ewyboy.auctionhouse.data.json;

import com.ewyboy.auctionhouse.util.ModLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class BaseJsonHandler<T> implements JsonHandler<T> {

    private final Gson gson;
    private final Class<T> clazz;

    public BaseJsonHandler(Class<T> clazz) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.clazz = clazz;
    }

    public void createOrUpdate(T object, String filePath) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(object, writer);
        } catch (IOException e) {
            ModLogger.error("Failed to write to file :: " + filePath, e);
        }
    }

    public T read(String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            ModLogger.error("Failed to read from file :: " + filePath, e);
        }
        return null;
    }

    public void delete(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            var result = file.delete();
            if (result) {
                ModLogger.info("File deleted :: " + filePath);
            } else {
                ModLogger.error("Failed to delete file :: " + filePath);
            }
        }
    }

}