package com.ewyboy.auctionhouse.commands;

import com.ewyboy.auctionhouse.AuctionHouse;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import net.minecraft.commands.CommandSourceStack;

public class AHCommands {

    public static void init() {
        CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> dispatcher.register(
                LiteralArgumentBuilder.<CommandSourceStack> literal(AuctionHouse.MOD_ID)
                        .then(CommandCheckBalance.register())
                        .executes(ctx -> 0)
        ));
    }

}
