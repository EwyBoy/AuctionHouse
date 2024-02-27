package com.ewyboy.auctionhouse.content;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AuctionBlock extends BaseBlockEntity<AuctionBlockEntity> {

    public AuctionBlock() {
        super(Properties.of().strength(2.0F).pushReaction(PushReaction.IGNORE));
    }

    @Override
    protected BlockEntityType.BlockEntitySupplier<AuctionBlockEntity> getBlockEntityTypeSupplier() {
        return AuctionBlockEntity::new;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return AuctionBlockEntity::serverTick;
    }

}
