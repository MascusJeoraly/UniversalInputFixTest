package git.meowinnovation.inputfix.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by Fang0716 on 6/1/2014.
 *
 * @author Meow J
 */
public class KeyHandler {

    public final KeyBinding key;

    public KeyHandler() {
        //                    Description         Default key      Category
        key = new KeyBinding("Open Input Window", Keyboard.KEY_J, "Universal Input Fix");
        ClientRegistry.registerKeyBinding(key);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        //if (FMLClientHandler.instance().isGUIOpen(GuiChat.class))
        //return;
        if (key.isPressed()) {
            Minecraft mc = FMLClientHandler.instance().getClient();
            mc.setIngameNotInFocus();
            //TODO attach Window
            InputWindow.showGUI();
        }
    }
}
