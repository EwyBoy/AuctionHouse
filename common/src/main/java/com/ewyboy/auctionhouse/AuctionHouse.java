package com.ewyboy.auctionhouse;

import com.ewyboy.auctionhouse.commands.AHCommands;
import com.ewyboy.auctionhouse.commands.CommandCheckBalance;
import com.ewyboy.auctionhouse.data.json.DirectoryHandler;
import com.ewyboy.auctionhouse.data.records.PlayerWallet;
import com.ewyboy.auctionhouse.events.AHEvents;
import com.ewyboy.auctionhouse.util.ModLogger;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.event.events.common.PlayerEvent;
import net.minecraft.commands.CommandSourceStack;

import java.util.UUID;

public class AuctionHouse {

    public static final String MOD_ID = "auctionhouse";

    public static void init() {
        DirectoryHandler.init();
        AHEvents.init();
        AHCommands.init();
        AHRegistries.init();
    }


}
