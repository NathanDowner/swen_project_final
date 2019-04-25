package finalGui.eventListeners;

import java.util.EventListener;

public interface AddUserListener extends EventListener {
	public void addUserRequested(AddUserEvent e);
}
