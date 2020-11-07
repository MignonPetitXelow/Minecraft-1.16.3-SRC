package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;

public class SUpdateTileEntityPacket implements IPacket<IClientPlayNetHandler>
{
    private BlockPos blockPos;
    private int tileEntityType;
    private CompoundNBT nbt;

    public SUpdateTileEntityPacket()
    {
    }

    public SUpdateTileEntityPacket(BlockPos blockPosIn, int tileEntityTypeIn, CompoundNBT compoundIn)
    {
        this.blockPos = blockPosIn;
        this.tileEntityType = tileEntityTypeIn;
        this.nbt = compoundIn;
    }

    public void readPacketData(PacketBuffer buf) throws IOException
    {
        this.blockPos = buf.readBlockPos();
        this.tileEntityType = buf.readUnsignedByte();
        this.nbt = buf.readCompoundTag();
    }

    public void writePacketData(PacketBuffer buf) throws IOException
    {
        buf.writeBlockPos(this.blockPos);
        buf.writeByte((byte)this.tileEntityType);
        buf.writeCompoundTag(this.nbt);
    }

    public void processPacket(IClientPlayNetHandler handler)
    {
        handler.handleUpdateTileEntity(this);
    }

    public BlockPos getPos()
    {
        return this.blockPos;
    }

    public int getTileEntityType()
    {
        return this.tileEntityType;
    }

    public CompoundNBT getNbtCompound()
    {
        return this.nbt;
    }
}