package it.polimi.ingsw.clientRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;

/**
 * @author Sara
 * This is the client view with the connection rmi that to the apply of the changes on the client
 */
public class ClientRMIConnectionView extends UnicastRemoteObject
		implements ClientRMIConnectionViewRemote, Serializable {

	private ClientModel client;

	public ClientRMIConnectionView(ClientModel client) throws RemoteException {
		super();
		this.client = client;
	}


	private static final long serialVersionUID = 6111979881550001331L;

	@Override
	public void updateClient(Change c) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		
		c.applyChange(client);
	}
	
	public ClientModel getClientModel(){
		return client;
	}
}
