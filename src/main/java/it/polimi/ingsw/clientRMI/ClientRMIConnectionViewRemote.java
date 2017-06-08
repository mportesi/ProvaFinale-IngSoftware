package it.polimi.ingsw.clientRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.changes.Change;

public interface ClientRMIConnectionViewRemote extends Remote{
	// Interface to receive information from the server

	public void updateClient(Change c) throws RemoteException;
}
