package com.ewyboy.auctionhouse.data.json;

public interface JsonHandler<T> {
    void createOrUpdate(T object, String fileName);
    T read(String fileName);
    void delete(String fileName);
}
