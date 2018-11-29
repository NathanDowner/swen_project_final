package gui;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DocPane extends JPanel {
	public static File fileName;
	private boolean fileCreated = false;
	private String docName;

	/**
	 * Create the panel.
	 */
	public DocPane(String docName) {
		
		setPreferredSize(new Dimension(800, 600));
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(59, 53, 681, 329);
		add(textArea);
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String titleTxt = textArea.getText();
				createFile(titleTxt);
			}
		});
		btnSaveFile.setBounds(315, 479, 169, 48);
		add(btnSaveFile);
		this.docName = docName;
	}
	
	public boolean isFileCreated() {
		return this.fileCreated;
	}
	
	public void createFile(String content) {
		String path = CaseView.path+this.docName+".txt";
		System.out.println("got here first");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			System.out.println("got here");
			bw.write(content);
			bw.newLine();
			fileName = new File(path);
			fileCreated = true;
			JOptionPane.showMessageDialog(this, "File Successfully Created");
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
