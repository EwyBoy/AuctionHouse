package com.ewyboy.auctionhouse.data.records;

import java.util.UUID;

public record PlayerWallet(UUID playerUUID, int balance) {

    public String toJson() {
        return String.format("{ \"playerUUID\": \"%s\", \"balance\": %d }", playerUUID, balance);
    }

}
