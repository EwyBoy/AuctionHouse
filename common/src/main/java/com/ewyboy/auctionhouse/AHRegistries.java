package com.ewyboy.auctionhouse;

import com.ewyboy.auctionhouse.content.AuctionBlock;
import com.ewyboy.auctionhouse.content.AuctionBlockEntity;
import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class AHRegistries {

    public static final Supplier<RegistrarManager> MANAGER_SUPPLIER = Suppliers.memoize(() -> RegistrarManager.get(AuctionHouse.MOD_ID));

    public static <T> DeferredRegister<T> get(ResourceKey<Registry<T>> registry) {
        return DeferredRegister.create(AuctionHouse.MOD_ID, registry);
    }

    @SuppressWarnings("unchecked")
    public static <T> Registrar<T> create(ResourceLocation registryId) {
        return (Registrar<T>) MANAGER_SUPPLIER.get().builder(registryId).build();
    }

    public static final class CreativeTabs {
        public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = get(Registries.CREATIVE_MODE_TAB);
        public static final RegistrySupplier<CreativeModeTab> AUCTION_HOUSE_TAB = CREATIVE_TABS.register(
                AuctionHouse.MOD_ID,
                () -> CreativeTabRegistry.create(
                        Component.literal(AuctionHouse.MOD_ID),
                        () -> new ItemStack(net.minecraft.world.item.Items.CAULDRON.asItem())
                )
        );
    }

    public static final class Blocks {
        public static final DeferredRegister<Block> BLOCKS = get(Registries.BLOCK);
        public static final RegistrySupplier<Block> AUCTION_BLOCK = BLOCKS.register("auction", AuctionBlock::new);
    }

    public static final class BlockEntities {
        public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = get(Registries.BLOCK_ENTITY_TYPE);
        public static final RegistrySupplier<BlockEntityType<AuctionBlockEntity>> AUCTION_BLOCK_ENTITY = BLOCK_ENTITIES.register(
                "auction",
                () -> BlockEntityType.Builder.of(AuctionBlockEntity::new, Blocks.AUCTION_BLOCK.get()).build(null)
        );
    }

    public static final class Items {
        public static final DeferredRegister<Item> ITEMS = get(Registries.ITEM);
        public static final RegistrySupplier<Item> AUCTION_ITEM = ITEMS.register(
                "auction",
                () -> new BlockItem(Blocks.AUCTION_BLOCK.get(), new Item.Properties())
        );
    }

}
