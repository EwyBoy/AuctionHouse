package com.ewyboy.auctionhouse.forge;

import dev.architectury.platform.forge.EventBuses;
import com.ewyboy.auctionhouse.AuctionHouse;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AuctionHouse.MOD_ID)
public class AuctionHouseForge {
    public AuctionHouseForge() {
        EventBuses.registerModEventBus(AuctionHouse.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        AuctionHouse.init();
    }
}