package com.ewyboy.auctionhouse.data.json;

import com.ewyboy.auctionhouse.data.records.PlayerWallet;

import java.util.UUID;

public class PlayerJsonHandler extends BaseJsonHandler<PlayerWallet> {

    public PlayerJsonHandler() {
        super(PlayerWallet.class, DirectoryHandler.Game_DIR);
    }

}
