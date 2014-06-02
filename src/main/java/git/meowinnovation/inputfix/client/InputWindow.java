package git.meowinnovation.inputfix.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
		frame.getContentPane().add(comp, BorderLayout.CENTER);
		frame.setSize(288, 40);
		frame.setVisible(true);
		comp.requestFocus();
	}

}
