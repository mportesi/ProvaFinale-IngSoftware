package it.polimi.ingsw.serverRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;

public interface ServerRMIConnectionViewRemote extends Remote{
	

		public void registerClient(
				ClientRMIConnectionViewRemote clientStub) 
				throws RemoteException;

		//public void turnOn() throws RemoteException;

		//public void turnOff() throws RemoteException;

		//public void scommetti() throws RemoteException;

		//public void printModel() throws RemoteException;
	


}
