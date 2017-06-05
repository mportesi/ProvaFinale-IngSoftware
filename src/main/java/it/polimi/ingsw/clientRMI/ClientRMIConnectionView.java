package it.polimi.ingsw.clientRMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientRMIConnectionView extends UnicastRemoteObject implements ClientRMIConnectionViewRemote, Serializable{

	protected ClientRMIConnectionView() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6111979881550001331L;

	@Override
	public void updateClient(Change c) throws RemoteException {
		// Just prints what was received from the server
		System.out.println(c);
	}


}
