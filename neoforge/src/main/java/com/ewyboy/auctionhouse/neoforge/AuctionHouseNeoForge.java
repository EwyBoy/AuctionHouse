package com.ewyboy.auctionhouse.neoforge;

import com.ewyboy.auctionhouse.AuctionHouse;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@SuppressWarnings("unused")
@Mod(AuctionHouse.MOD_ID)
public final class AuctionHouseNeoForge {

    public AuctionHouseNeoForge(IEventBus modBus) {
        AuctionHouse.init();
        modBus.addListener(DataEvent::onGatherDataEvent);
    }

}
