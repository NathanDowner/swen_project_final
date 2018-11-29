package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class DocPane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField fNameField;

	/**
	 * Create the panel.
	 */
	public DocPane() {
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(59, 53, 681, 329);
		add(textArea);
		
		JLabel lblFileName = new JLabel("File Name:");
		lblFileName.setBounds(59, 426, 63, 13);
		add(lblFileName);
		
		fNameField = new JTextField();
		fNameField.setBounds(132, 423, 96, 19);
		add(fNameField);
		fNameField.setColumns(10);
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.setBounds(59, 477, 169, 48);
		add(btnSaveFile);
		
	}
}
