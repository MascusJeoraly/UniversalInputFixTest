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

package git.meowinnovation.inputfix.client;

import cpw.mods.fml.client.FMLClientHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InputWindow {

    public static void showGUI() {

        final JFrame frame = new JFrame("Input Window");
        final JTextArea comp = new JTextArea();

        frame.getContentPane().add(comp, BorderLayout.CENTER);
        frame.setSize(288, 40);
        frame.setVisible(true);
        FMLClientHandler.instance().getClient().setIngameNotInFocus();
        comp.requestFocus();

        KeyStroke enter = KeyStroke
                .getKeyStroke(KeyEvent.VK_ENTER, 0);
        KeyStroke esc = KeyStroke
                .getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        InputMap inputmap = comp.getInputMap();
        ActionMap actionmap = comp.getActionMap();

        Action enteraction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("enter");
            }

        };

        Action escaction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent event) {
                frame.dispose();
            }

        };


        inputmap.put(enter, "enter");
        inputmap.put(esc, "esc");
        actionmap.put("enter", enteraction);
        actionmap.put("esc", escaction);
        //TODO replace it
        FMLClientHandler.instance().getClient().thePlayer.sendChatMessage("test");
    }


}
