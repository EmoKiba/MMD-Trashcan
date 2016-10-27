package kiba.trashcan;

import kiba.trashcan.blocks.TileTrashCan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class GuiHandler implements IGuiHandler {
    public static int GUI_ID;

    public static int GUI_TRASHCAN = nextID();
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_TRASHCAN){

            TileEntity te = world.getTileEntity(new BlockPos(x,y,z));
            if(te!=null && te instanceof TileTrashCan)
                return new ContainerTrashCan((IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP), ((TileTrashCan) te).inv, player);


        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_TRASHCAN){
            TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
            if (te != null && te instanceof TileTrashCan) {
                return new GuiTrashCan(new ContainerTrashCan((IItemHandler) player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.UP), ((TileTrashCan) te).inv, player));
            }


        }
        return null;
    }
    public static int nextID(){
       return GUI_ID++;
    }
    
    public static void launchGui(int ID, EntityPlayer playerIn, World worldIn, int x, int y, int z) {
		playerIn.openGui(TrashCan.INSTANCE, ID, worldIn, x, y, z);
	}
}
