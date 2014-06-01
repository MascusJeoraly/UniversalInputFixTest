package git.meowinnovation.inputfix;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Fang0716 on 6/1/2014.
 *
 * @author Meow J
 */
@Mod(modid = UniversalInputFix.MODID, name = UniversalInputFix.NAME, version = "0.0.1")
public class UniversalInputFix {
    public static final String MODID = "UniversalInputFix";
    public static final String NAME = "Universal Input Fix";

    @Mod.Instance(UniversalInputFix.MODID)
    public static UniversalInputFix instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}
