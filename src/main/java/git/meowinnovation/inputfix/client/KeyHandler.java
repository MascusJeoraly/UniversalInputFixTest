package git.meowinnovation.inputfix.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

/**
 * Created by Fang0716 on 6/1/2014.
 * 
 * @author Meow J
 */
public class KeyHandler {

	public final KeyBinding inputkey;
	public final KeyBinding commandkey;

	public KeyHandler() {

		String inputdescription;
		String commanddescription;
		String category = "Universal Input Fix";
		if (FMLClientHandler.instance().getCurrentLanguage()
				.equalsIgnoreCase("zh_CN")) {
			inputdescription = "打开UIF输入窗口";
			commanddescription = "打开UIF命令输入窗口";
		} else {
			inputdescription = "Open Input Window";
			commanddescription = "Open Command Window";
		}
		inputkey = new KeyBinding(inputdescription, Keyboard.KEY_J, category);
		commandkey = new KeyBinding(commanddescription, Keyboard.KEY_C,
				category);

		ClientRegistry.registerKeyBinding(inputkey);
		ClientRegistry.registerKeyBinding(commandkey);

	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		// if (FMLClientHandler.instance().isGUIOpen(GuiChat.class))
		// return;
		if (inputkey.isPressed()) {
			Minecraft mc = FMLClientHandler.instance().getClient();
			// TODO attach Window
			if (FMLClientHandler.instance().getClient().thePlayer != null) {
				FMLClientHandler.instance().displayGuiScreen(
						FMLClientHandler.instance().getClient().thePlayer,
						new GuiChat());
				InputWindow.showGUI();
				System.out.println(FMLClientHandler.instance()
						.getCurrentLanguage());
			}
		}
		if (commandkey.isPressed()) {

		}
	}
}