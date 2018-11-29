package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DocPane extends JPanel {
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
		btnSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fileName = fNameField.getText();
				String titleTxt = textArea.getText();
				createFile(fileName, titleTxt);
			}
		});
		btnSaveFile.setBounds(59, 477, 169, 48);
		add(btnSaveFile);
		
	}
	
	public void createFile(String title, String content) {
		System.out.println("got here first");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\Files\\"+title+".txt"))) {
			System.out.println("got here");
			bw.write(content);
			bw.newLine();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
