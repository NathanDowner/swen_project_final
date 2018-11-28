package gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StatOfAccScreen extends JPanel {
	private JTextField totalField;

	/**
	 * Create the panel.
	 */
	public StatOfAccScreen(String txt, double total) {
		setLayout(null);
		setPreferredSize(new Dimension(500, 450));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(txt);
		textArea.setBounds(20, 27, 453, 287);
		add(textArea);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(24, 345, 45, 13);
		add(lblTotal);
		
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setBounds(79, 342, 96, 19);
		totalField.setText(Double.toString(total));
		add(totalField);
		totalField.setColumns(10);

	}

}
