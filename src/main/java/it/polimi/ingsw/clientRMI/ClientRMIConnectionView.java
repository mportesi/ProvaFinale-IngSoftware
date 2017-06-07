package it.polimi.ingsw.clientRMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;

public class ClientRMIConnectionView extends UnicastRemoteObject implements ClientRMIConnectionViewRemote, Serializable{

	private ClientModel client;
	
	public ClientRMIConnectionView() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6111979881550001331L;

	@Override
	public void updateClient(Change c) throws RemoteException {
		
		c.applyChange(client);
	}



}
