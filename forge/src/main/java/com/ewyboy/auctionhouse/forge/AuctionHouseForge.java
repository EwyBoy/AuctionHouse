package com.ewyboy.auctionhouse.forge;

import dev.architectury.platform.forge.EventBuses;
import com.ewyboy.auctionhouse.AuctionHouse;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AuctionHouse.MOD_ID)
public class AuctionHouseForge {
    public AuctionHouseForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(AuctionHouse.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        AuctionHouse.init();
    }
}