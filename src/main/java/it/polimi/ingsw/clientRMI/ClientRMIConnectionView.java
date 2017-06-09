package it.polimi.ingsw.clientRMI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeInitializePlay;
import it.polimi.ingsw.client.ClientModel;

public class ClientRMIConnectionView extends UnicastRemoteObject
		implements ClientRMIConnectionViewRemote, Serializable {

	private ClientModel client;

	public ClientRMIConnectionView(ClientModel client) throws RemoteException {
		super();
		this.client = client;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6111979881550001331L;

	@Override
	public void updateClient(Change c) throws RemoteException {
		if (c instanceof ChangeInitializePlay) {
			System.out.println("ok posso inizializzare il gioco");
			c.applyChange(client);
		}
		System.out.println("sono nel CLient prima updateClient(c)" + c);
		c.applyChange(client);
		System.out.println("sono nel Client dopo updateClient(c)" + c);
	}

}
