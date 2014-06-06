/*
 * Copyright (C) 2014  Fang0716
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package git.meowinnovation.inputfix.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import git.meowinnovation.inputfix.client.InputWindow;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;

import java.io.IOException;

/**
 * Created by Fang0716 on 6/2/2014.
 *
 * @author Meow J
 */
public class EventHandler {
    public static EventHandler instance = new EventHandler();

    @SubscribeEvent
    public void onOpenGui(GuiOpenEvent event) throws IOException {
        if (event.gui == null) {
            return;
        } else if (event.gui.getClass() == GuiMainMenu.class) {
            InputWindow.closeframe();
        }
    }


}
