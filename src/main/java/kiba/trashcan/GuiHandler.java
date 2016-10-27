package kiba.trashcan;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    public static int GUI_ID;

    public static int GUI_TRASHCAN = nextID();
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_TRASHCAN){


        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_TRASHCAN){

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
