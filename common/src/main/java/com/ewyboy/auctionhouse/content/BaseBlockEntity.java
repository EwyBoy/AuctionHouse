package com.ewyboy.auctionhouse.content;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseBlockEntity<T extends BlockEntity> extends Block implements EntityBlock {

    protected abstract BlockEntityType.BlockEntitySupplier<T> getBlockEntityTypeSupplier();

    public BaseBlockEntity(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("unchecked")
    protected T getBlockEntity(Level world, BlockPos pos) {
        return (T) world.getBlockEntity(pos);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return getBlockEntityTypeSupplier().create(blockPos, blockState);
    }

}
