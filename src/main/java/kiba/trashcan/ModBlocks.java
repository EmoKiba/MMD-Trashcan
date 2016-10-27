package kiba.trashcan;

import kiba.trashcan.blocks.BlockTrashCan;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    public static BlockTrashCan trashCanBlock;
    public static void init(){
        trashCanBlock = new BlockTrashCan();
    }
    @SideOnly(Side.CLIENT)
    public static void initModels() {
    	trashCanBlock.initModel();
    }

}
