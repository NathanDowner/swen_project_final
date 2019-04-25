package practise;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
//	public static Dimension dim = new Dimension(900, 600);
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel; 
	
	public MainFrame() {
		super("Johnson & Downer");
				
		
		this.setLayout(new BorderLayout());
		
		this.toolbar = new Toolbar();
		this.textPanel = new TextPanel();
		this.formPanel = new FormPanel();
		
		this.formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				String ageCat = e.getAgeCategory().getText();
				String empCat = e.getEmpCategory();
				
				textPanel.appendText(name + ", " + occupation + " "+ ageCat + ", "+ empCat +"\n");
			}
		});
		
		this.toolbar.setStringListener(new StringListener() {
			public void textEmitted(String text) {
				textPanel.appendText(text);	
			}
		});
	
		this.add(textPanel, BorderLayout.CENTER);
		this.add(toolbar, BorderLayout.NORTH);
		this.add(formPanel, BorderLayout.WEST);
		
//		this.pack();
		this.setSize(600, 500);
		this.setMinimumSize(new Dimension(500, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

}
