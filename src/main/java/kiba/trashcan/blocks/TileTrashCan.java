package kiba.trashcan.blocks;

import kiba.trashcan.ContainerTrashCan;
import kiba.trashcan.GuiHandler;
import kiba.trashcan.IContainerCallbacks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.wrapper.InvWrapper;

public class TileTrashCan extends TileEntityItemHandler implements IContainerCallbacks {


    @Override
    public void onContainerOpened(EntityPlayer player) {

    }

    @Override
    public void onContainerClosed(EntityPlayer player) {

    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    protected IItemHandler createInventory() {
        return new ItemStackHandler(1);
    }

    @Override
    public Container createContainer(EntityPlayer player) {
        final IItemHandlerModifiable playerInventory = (IItemHandlerModifiable) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP);
        final IItemHandler playerInventoryWrapper = new CombinedInvWrapper(new InvWrapper(player.inventory), playerInventory);

        return new ContainerTrashCan(playerInventoryWrapper, inventory, player, this);

    }

    @Override
    protected int getGuiId() {
        return GuiHandler.GUI_TRASHCAN;
    }
}
