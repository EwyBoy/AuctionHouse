package com.ewyboy.auctionhouse.events;

import com.ewyboy.auctionhouse.data.json.DirectoryHandler;
import com.ewyboy.auctionhouse.data.records.PlayerWallet;
import com.ewyboy.auctionhouse.util.ModLogger;
import dev.architectury.event.events.common.PlayerEvent;

import java.util.UUID;

public class PlayerEvents {

    public static void init() {
        playerJoin();
        playerQuit();
    }

    private static void playerJoin() {
        PlayerEvent.PLAYER_JOIN.register(player -> {
            UUID playerUUID = player.getUUID();
            ModLogger.info("Player joined :: " + playerUUID);
            PlayerWallet wallet = DirectoryHandler.PLAYER_WALLET_HANDLER.read(playerUUID.toString());
            if (wallet == null) {
                wallet = new PlayerWallet(playerUUID, 0);
                DirectoryHandler.PLAYER_WALLET_HANDLER.createOrUpdate(wallet, playerUUID.toString());
            }
        });
    }

    private static void playerQuit() {
        PlayerEvent.PLAYER_QUIT.register(player -> {
            UUID playerUUID = player.getUUID();
            ModLogger.info("Player left :: " + playerUUID);
            DirectoryHandler.PLAYER_WALLET_HANDLER.read(playerUUID.toString());
        });
    }

}
