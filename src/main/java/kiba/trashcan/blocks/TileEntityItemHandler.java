package kiba.trashcan.blocks;

import kiba.trashcan.TrashCan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A {@link TileEntity} with a single {@link IItemHandler} inventory.
 *
 *
 * @param <INVENTORY> The inventory type
 */
public abstract class TileEntityItemHandler<INVENTORY extends IItemHandler & INBTSerializable<NBTTagCompound>> extends TileEntity {
    /**
     * The inventory.
     */
    protected final INVENTORY inventory = createInventory();

    /**
     * Create and return the inventory.
     *
     * @return The inventory
     */
    protected abstract INVENTORY createInventory();

    /**
     * Open the GUI for the specified player.
     *
     * @param world  The world
     * @param player The player
     */
    public void openGUI(World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.openGui(TrashCan.MODID, getGuiId(), world, pos.getX(), pos.getY(), pos.getZ());
        }
    }

    /**
     * Create a {@link Container} of this inventory for the specified player.
     *
     * @param player The player
     * @return The Container
     */
    public abstract Container createContainer(EntityPlayer player);

    /**
     * Get the GUI ID.
     *
     * @return The GUI ID
     */
    protected abstract int getGuiId();

    /**
     * Get the inventory contents to drop.
     *
     * @return The drops list
     */
    public List<ItemStack> getDrops() {
        return dropItemHandlerContents(inventory, getWorld().rand);
    }
    public  List<ItemStack> dropItemHandlerContents(IItemHandler itemHandler, Random random) {
        final List<ItemStack> drops = new ArrayList<ItemStack>();


        for (int slot = 0; slot < itemHandler.getSlots(); ++slot) {
            while (itemHandler.getStackInSlot(slot) != null) {
                final int amount = random.nextInt(21) + 10;

                if (itemHandler.extractItem(slot, amount, true) != null) {
                    final ItemStack itemStack = itemHandler.extractItem(slot, amount, false);
                    drops.add(itemStack);
                }
            }
        }

        return drops;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        inventory.deserializeNBT(compound.getCompoundTag("ItemHandler"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("ItemHandler", inventory.serializeNBT());
        return compound;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(inventory);
        }

        return super.getCapability(capability, facing);
    }
}