package it.polimi.ingsw.serverRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;

public interface ServerRMIConnectionViewRemote extends Remote {

	public void registerClient(ClientRMIConnectionViewRemote clientStub, String name)
			throws RemoteException, FileNotFoundException, NullPointerException, IOException, ParseException;

	public void initializeGame(ClientRMIConnectionViewRemote clientStub)
			throws FileNotFoundException, NullPointerException, IOException, ParseException;

	public void notifyObserver(Action action)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, RemoteException;

}
