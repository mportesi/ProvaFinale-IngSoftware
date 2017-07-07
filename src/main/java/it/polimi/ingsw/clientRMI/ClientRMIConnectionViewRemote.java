package it.polimi.ingsw.clientRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;

public interface ClientRMIConnectionViewRemote extends Remote {
	// Interface to receive information from the server

	public void updateClient(Change c) throws RemoteException, FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException;
	
}
