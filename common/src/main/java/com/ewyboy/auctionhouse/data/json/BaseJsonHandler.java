package com.ewyboy.auctionhouse.data.json;

import com.ewyboy.auctionhouse.util.ModLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Path;

public class BaseJsonHandler<T> implements JsonHandler<T> {

    private final Gson gson;
    private final Class<T> clazz;
    private Path baseDirectoryPath; // Base directory for storing JSON files

    public BaseJsonHandler(Class<T> clazz, Path baseDirectoryPath) {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.clazz = clazz;
        this.baseDirectoryPath = baseDirectoryPath;
    }

    // Method to generate file path from file name
    private String getFilePath(String fileName) {
        return baseDirectoryPath + File.separator + fileName + ".json";
    }

    @Override
    public void createOrUpdate(T object, String fileName) {
        String filePath = getFilePath(fileName);
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(object, writer);
        } catch (IOException e) {
            ModLogger.error("Failed to write to file :: " + filePath, e);
        }
    }

    @Override
    public T read(String fileName) {
        String filePath = getFilePath(fileName);
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            ModLogger.error("Failed to read from file :: " + filePath, e);
        }
        return null;
    }

    @Override
    public void delete(String fileName) {
        String filePath = getFilePath(fileName);
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                ModLogger.info("File deleted :: " + filePath);
            } else {
                ModLogger.error("Failed to delete file :: " + filePath);
            }
        }
    }

    // Getter and Setter for baseDirectoryPath if needed
    public Path getBaseDirectoryPath() {
        return baseDirectoryPath;
    }

    public void setBaseDirectoryPath(Path baseDirectoryPath) {
        this.baseDirectoryPath = baseDirectoryPath;
    }
}
