package kiba.trashcan;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event){
    	super.preInit(event);
    	ModBlocks.initModels();
    }
    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){
    	
    }
}
