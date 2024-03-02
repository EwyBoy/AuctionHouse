package com.ewyboy.auctionhouse.commands;

import com.ewyboy.auctionhouse.data.json.DirectoryHandler;
import com.ewyboy.auctionhouse.data.records.PlayerWallet;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

import java.util.Objects;
import java.util.UUID;

public class CommandCheckBalance {

    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("balance").requires((commandSource) -> commandSource.hasPermission(2))
                .executes((commandSource) -> balance(
                                commandSource.getSource()
                        )
                );
    }

    private static int balance(CommandSourceStack source) {
        UUID playerUUID = Objects.requireNonNull(source.getPlayer()).getUUID();
        PlayerWallet wallet = DirectoryHandler.PLAYER_WALLET_HANDLER.read(playerUUID.toString());
        source.sendSuccess(() -> Component.literal("Your balance is: " + wallet.balance()), false);

        return 0;
    }

}
