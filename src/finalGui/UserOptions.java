package finalGui;

import javax.swing.JPanel;

import finalGui.eventListeners.LogoutListener;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserOptions extends JPanel {

	private static final long serialVersionUID = 1L;
	private LogoutListener listener;

	/**
	 * Create the panel.
	 */
	public UserOptions() {
		setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Log Me Out PLEEEASE!!!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listener != null) {
					listener.logoutRequested();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(btnNewButton);

	}
	
	public void setLogoutListener(LogoutListener listener) {
		this.listener = listener;
	}

}
