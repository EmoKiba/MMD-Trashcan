package kiba.trashcan;

import kiba.trashcan.blocks.BlockTrashCan;
import net.minecraft.block.Block;

public class ModBlocks {
    public static Block trashCanBlock;
    public static void init(){
        trashCanBlock = new BlockTrashCan();

    }

}
