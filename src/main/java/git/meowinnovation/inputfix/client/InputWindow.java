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
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InputWindow extends JFrame {
    final static JFrame frame = new JFrame("Input Window");
    final static JTextArea comp = new JTextArea();
    final static JScrollPane scroll = new JScrollPane(comp);
    final static Font font = new Font("微软雅黑", 0, 17);

    public static void showGUI(String text) {
        frame.getContentPane().add(scroll, BorderLayout.CENTER);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        comp.setFont(font);

        if (text.equalsIgnoreCase("/")) {
            comp.setText(text);
            comp.setSelectionStart(1);
            comp.setSelectionEnd(1);
        }
        frame.setSize(Display.getWidth(), 25);
        frame.setUndecorated(true);
        frame.setLocation(Display.getX(), Display.getY() + Display.getHeight() + 30);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);

        //Request focus
        FMLClientHandler.instance().getClient().setIngameNotInFocus();
        comp.requestFocus();

        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        InputMap inputmap = comp.getInputMap();
        ActionMap actionmap = comp.getActionMap();

        Action enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!StringUtils.isNullOrEmpty(comp.getText())) {
                    FMLClientHandler.instance().getClient().thePlayer.sendChatMessage(comp.getText());
                    comp.setText("");
                    frame.dispose();
                    FMLClientHandler.instance().getClient().thePlayer.closeScreen();
                    FMLClientHandler.instance().getClient().setIngameFocus();
                } else {
                    comp.setText("");
                    frame.dispose();
                    FMLClientHandler.instance().getClient().thePlayer.closeScreen();
                    FMLClientHandler.instance().getClient().setIngameFocus();
                }
            }
        };

        Action escAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent event) {
                comp.setText("");
                frame.dispose();
                FMLClientHandler.instance().getClient().thePlayer.closeScreen();
                FMLClientHandler.instance().getClient().setIngameFocus();
            }
        };

        inputmap.put(enter, "enter");
        inputmap.put(esc, "esc");
        actionmap.put("enter", enterAction);
        actionmap.put("esc", escAction);

    }

    public static void closeframe() {
        frame.dispose();
    }

    public static boolean isFrameDisplayable() {
        return frame.isDisplayable();
    }
}
