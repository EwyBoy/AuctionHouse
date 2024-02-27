package com.ewyboy.auctionhouse.neoforge;

import com.ewyboy.auctionhouse.AuctionHouse;
import net.neoforged.fml.common.Mod;

@SuppressWarnings("unused")
@Mod(AuctionHouse.MOD_ID)
public final class AuctionHouseNeoForge {

    public AuctionHouseNeoForge() {
        AuctionHouse.init();
    }

}
