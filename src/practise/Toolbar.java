package practise;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener {
	
	private JButton helloBtn, goodbyeBtn;
	private StringListener listener;
	
	public Toolbar() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		helloBtn = new JButton("Hello");
		helloBtn.addActionListener(this);
		
		goodbyeBtn = new JButton("Goodbye");
		goodbyeBtn.addActionListener(this);
		
		add(helloBtn);
		add(goodbyeBtn);
		this.setBorder(BorderFactory.createEtchedBorder(1));
		
	}
	
	public void setStringListener(StringListener sl) {
		this.listener = sl;
	}

	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton) e.getSource();
		if (this.listener != null) {
			if (src == this.helloBtn) {
				this.listener.textEmitted("Hello\n");
			} else {
				this.listener.textEmitted("Goodbye\n");
			}
		}
	}
	

}
