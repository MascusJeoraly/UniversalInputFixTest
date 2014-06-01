package git.meowinnovation.inputfix.client;

import cpw.mods.fml.common.FMLCommonHandler;
import git.meowinnovation.inputfix.common.CommonProxy;

/**
 * Created by Fang0716 on 6/1/2014.
 *
 * @author Meow J
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void init() {
        super.init();
        FMLCommonHandler.instance().bus().register(new KeyHandler());
    }
}
