package it.polimi.ingsw.serverRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;

public interface ServerRMIConnectionViewRemote extends Remote {
	

		public void registerClient(
				ClientRMIConnectionViewRemote clientStub) 
				throws RemoteException;
		
		public void notifyObserver(Action action) throws RemoteException; //???
		
		


}
