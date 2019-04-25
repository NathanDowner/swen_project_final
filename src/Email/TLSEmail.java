package Email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JOptionPane;

import backend.Client;

public class TLSEmail {

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.gmail.com (use authentication)
	   Use Authentication: Yes
	   Port for TLS/STARTTLS: 587
	 */
	private final String fromEmail = "johndownlaw@gmail.com"; //requires valid gmail id
	private final String password = "johndownlaw2140"; // correct password for gmail id
	Properties props;
	Authenticator auth;
	Session session;
	
	public TLSEmail() {
		
		props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		session = Session.getInstance(props, auth);
	}
	
	private void sendTLSEmail(String receiverEmail, String heading, String body) {
		System.out.println("TLSEmail Start");
		try {
			EmailUtil.sendEmail(session, receiverEmail, heading, body);
			JOptionPane.showMessageDialog(null,"Email Sent Successfully!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Email Sent Successfully!!");
		}
	}
	
	public void sendUpdateEmail(Client receiver, String prevAction, String updatedAction) {
		String heading = "Case Update!";
		String clientName = receiver.getFullName();
		String email = receiver.getEmail();
		String body = String.format("Dear %s,\n\n\t\tThere has been an update in the status of your case. It is as follows:\n", clientName);
		body += String.format("Previous action carried out: %s\n", prevAction);
		body += String.format("Action just carried out: %s\n", updatedAction);
		sendTLSEmail(email, heading, body);
		
	}
}