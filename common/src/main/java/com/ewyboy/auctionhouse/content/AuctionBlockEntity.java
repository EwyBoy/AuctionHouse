package com.ewyboy.auctionhouse.content;

import com.ewyboy.auctionhouse.AHRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class AuctionBlockEntity extends BlockEntity {

    private int auctionTime;

    public AuctionBlockEntity(BlockPos pos, BlockState state) {
        super(AHRegistries.BlockEntities.AUCTION_BLOCK_ENTITY.get(), pos, state);
        this.auctionTime = 0;
    }

    public static <T extends BlockEntity> void serverTick(Level level, BlockPos blockPos, BlockState blockState, T blockEntity) {
        if (blockEntity instanceof AuctionBlockEntity entity) {
            if (level != null && !level.isClientSide()) {
                entity.auctionTime++;
                entity.setChanged();
            }
        }
    }

    public int getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(int auctionTime) {
        this.auctionTime = auctionTime;
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        compoundTag.putInt("auctionTime", auctionTime);
        super.saveAdditional(compoundTag);
    }

    @Override
    public void load(CompoundTag tag) {
        auctionTime = tag.getInt("auctionTime");
        super.load(tag);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.putInt("auctionTime", auctionTime);
        return tag;
    }

}
