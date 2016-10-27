package kiba.trashcan;

import kiba.trashcan.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TrashCan.MODID, version = TrashCan.VERSION, name = TrashCan.MODNAME)
public class TrashCan {
    public static final String MODID = "trashcan";
    public static final String VERSION = "0.0.1";
    public static final String MODNAME = "Trash Can";

    @SidedProxy(clientSide = "kiba.trashcan.ClientProxy", serverSide = "kiba.trashcan.CommonProxy")
    public static CommonProxy PROXY;

    @Mod.Instance("trashcan")
    public static TrashCan INSTANCE;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        INSTANCE = this;
        PROXY.preInit(event);
    }
    @Mod.EventHandler
    public void Init(FMLInitializationEvent event){

    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }


}
