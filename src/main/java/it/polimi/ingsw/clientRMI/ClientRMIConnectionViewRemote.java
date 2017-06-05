package it.polimi.ingsw.clientRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientRMIConnectionViewRemote extends Remote {
	// Interface to receive information from the server

	public void updateClient(Change c) throws RemoteException;
}
