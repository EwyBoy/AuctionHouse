package com.ewyboy.auctionhouse.data.json;

import java.io.IOException;

public interface JsonHandler<T> {
    void createOrUpdate(T object, String filePath) throws IOException;
    T read(String filePath) throws IOException;
    void delete(String filePath);
}
