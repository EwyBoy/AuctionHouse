package com.ewyboy.auctionhouse.neoforge;

import com.ewyboy.auctionhouse.AHRegistries;
import com.ewyboy.auctionhouse.AuctionHouse;
import com.ewyboy.auctionhouse.util.ModLogger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataEvent {

    public static void onGatherDataEvent(GatherDataEvent event) {
        ModLogger.error("Gathering data for Auction House");
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();

        gen.addProvider(event.includeClient(), new BlockState(output, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new ItemModel(output, event.getExistingFileHelper()));
        gen.addProvider(event.includeClient(), new Lang(output, "en_us"));
    }

    public static class BlockState extends BlockStateProvider {
        public BlockState(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, AuctionHouse.MOD_ID, exFileHelper);
        }

        @Override
        protected void registerStatesAndModels() {
            simpleBlock(AHRegistries.Blocks.AUCTION_BLOCK.get());
        }
    }

    public static class ItemModel extends ItemModelProvider {
        public ItemModel(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, AuctionHouse.MOD_ID, exFileHelper);
        }

        @Override
        protected void registerModels() {
            cubeAll(AHRegistries.Items.AUCTION_ITEM.getId().getPath(), modLoc("block/auction"));
        }
    }

    public static class Lang extends LanguageProvider {

        public Lang(PackOutput output, String locale) {
            super(output, AuctionHouse.MOD_ID, locale);
        }

        @Override
        protected void addTranslations() {
            addBlock(AHRegistries.Blocks.AUCTION_BLOCK, "Auction Block");
        }
    }

}
