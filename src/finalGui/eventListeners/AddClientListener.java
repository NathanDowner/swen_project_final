package gui;

import java.util.EventListener;

public interface AddClientListener extends EventListener {
	public void addClientRequested(AddClientEvent e);
}