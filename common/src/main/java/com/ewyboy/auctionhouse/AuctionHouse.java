package com.ewyboy.auctionhouse;

import com.ewyboy.auctionhouse.commands.AHCommands;
import com.ewyboy.auctionhouse.data.json.DirectoryHandler;
import com.ewyboy.auctionhouse.events.AHEvents;

public class AuctionHouse {

    public static final String MOD_ID = "auctionhouse";

    public static void init() {
        DirectoryHandler.init();
        AHEvents.init();
        AHCommands.init();
        AHRegistries.init();
    }


}
