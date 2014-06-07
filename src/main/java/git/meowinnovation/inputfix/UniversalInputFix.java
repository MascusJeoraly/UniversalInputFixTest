package git.meowinnovation.inputfix;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import git.meowinnovation.inputfix.common.CommonProxy;

/**
 * Created by Fang0716 on 6/1/2014.
 *
 * @author Meow J and Brian
 */
@Mod(modid = UniversalInputFix.MODID, name = UniversalInputFix.NAME, version = "0.0.2")
public class UniversalInputFix {
    public static final String MODID = "UniversalInputFix";
    public static final String NAME = "Universal Input Fix";

    @Mod.Instance(UniversalInputFix.MODID)
    public static UniversalInputFix instance;

    @SidedProxy(clientSide = "git.meowinnovation.inputfix.client.ClientProxy", serverSide = "git.meowinnovation.inputfix.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
