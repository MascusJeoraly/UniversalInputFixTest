package git.meowinnovation.inputfix.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Keyboard;

/**
 * Created by Fang0716 on 6/1/2014.
 *
 * @author Meow J
 */
public class KeyHandler {

    public final KeyBinding inputKey;
    public final KeyBinding commandKey;

    public KeyHandler() {

        final String category = "Universal Input Fix";

        inputKey = new KeyBinding(StatCollector.translateToLocal("msg.openinput.name"), Keyboard.KEY_T, category);
        commandKey = new KeyBinding(StatCollector.translateToLocal("msg.opencmd.name"), Keyboard.KEY_SLASH, category);

        ClientRegistry.registerKeyBinding(inputKey);
        ClientRegistry.registerKeyBinding(commandKey);

    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft mc = FMLClientHandler.instance().getClient();
        if (mc.thePlayer != null && !InputWindow.isFrameDisplayable()) {
            if (inputKey.isPressed()) {
                InputWindow.showGUI("");
                FMLClientHandler.instance().displayGuiScreen(FMLClientHandler.instance().getClient().thePlayer, new GuiChat());
            }
            if (commandKey.isPressed()) {
                InputWindow.showGUI("/");
                FMLClientHandler.instance().displayGuiScreen(FMLClientHandler.instance().getClient().thePlayer, new GuiChat());
            }
        }
    }
}