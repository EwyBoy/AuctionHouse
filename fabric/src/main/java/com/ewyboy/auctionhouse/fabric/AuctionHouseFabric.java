package com.ewyboy.auctionhouse.fabric;

import com.ewyboy.auctionhouse.AuctionHouse;
import net.fabricmc.api.ModInitializer;

public class AuctionHouseFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AuctionHouse.init();
    }
}