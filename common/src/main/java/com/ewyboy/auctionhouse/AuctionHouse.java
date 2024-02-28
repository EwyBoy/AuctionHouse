package com.ewyboy.auctionhouse;

import com.ewyboy.auctionhouse.data.json.DirectoryHandlerService;

public class AuctionHouse {

    public static final String MOD_ID = "auctionhouse";

    public static void init() {

        DirectoryHandlerService.init();

        AHRegistries.Blocks.BLOCKS.register();
        AHRegistries.BlockEntities.BLOCK_ENTITIES.register();
        AHRegistries.Items.ITEMS.register();
        AHRegistries.CreativeTabs.CREATIVE_TABS.register();
    }
}
