package git.meowinnovation.inputfix.client;

import java.awt.BorderLayout;
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

public class InputWindow {

	public static void showGUI() {
		JFrame frame = new JFrame("Input Window");
		final JTextArea comp = new JTextArea();
		KeyStroke enter_keystroke = KeyStroke
				.getKeyStroke(KeyEvent.VK_ENTER, 0);

		frame.getContentPane().add(comp, BorderLayout.CENTER);
		frame.setSize(288, 40);
		frame.setVisible(true);
		comp.requestFocus();

		Action send_message_then_clear_action = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(comp.getText());
			}

		};
		InputMap inputmap = comp.getInputMap();
		ActionMap actionmap = comp.getActionMap();
		inputmap.put(enter_keystroke,"send-message-then-clear");
		actionmap.put("send-message-then-clear",send_message_then_clear_action);
	}

}
