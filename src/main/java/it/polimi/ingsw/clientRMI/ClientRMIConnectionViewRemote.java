package it.polimi.ingsw.clientRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;
/**
 * @author Sara
 * This is the interface to receive the informations from the server
 */
public interface ClientRMIConnectionViewRemote extends Remote {
	

	public void updateClient(Change c) throws RemoteException, FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;
	public ClientModel getClientModel() throws RemoteException;
}
