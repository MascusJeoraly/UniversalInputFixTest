package git.meowinnovation.inputfix.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;

import cpw.mods.fml.client.FMLClientHandler;

public class InputWindow {

	public static void showGUI() {

		final JFrame frame = new JFrame("Input Window");
		final JTextArea comp = new JTextArea();

		Toolkit tk = Toolkit.getDefaultToolkit();// 得到Toolkit对象(实例化)
		Dimension screen = tk.getScreenSize();// 得到屏幕的大小

		frame.getContentPane().add(comp, BorderLayout.CENTER);
		frame.setSize(screen.width, 20);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setLocation(0, screen.height - 20);
		comp.requestFocus();

		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		InputMap inputmap = comp.getInputMap();
		ActionMap actionmap = comp.getActionMap();

		Action enteraction = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent event) {
				sendMessage(comp.getText());
				frame.dispose();
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
	}

	public static void sendMessage(String message) {
		FMLClientHandler.instance().getClient().thePlayer
				.sendChatMessage(message);
	}

}
