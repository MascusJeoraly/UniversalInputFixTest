package git.meowinnovation.inputfix.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class InputWindow {

	public static void showGUI() {
		JFrame frame = new JFrame("Input Window");
		JComponent comp = new JTextArea();
		JButton enter = new JButton("233");
		enter.setMnemonic(KeyEvent.VK_ENTER);
		frame.getContentPane().add(comp, BorderLayout.CENTER);
		frame.setSize(288, 40);
		enter.setSize(20, 40);
		frame.setVisible(true);
		enter.setVisible(true);
		comp.requestFocus();
	}

}
