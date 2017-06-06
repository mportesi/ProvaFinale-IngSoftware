package it.polimi.ingsw.serverRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;

public interface ServerRMIConnectionViewRemote extends Remote{
	

		public void registerClient(
				ClientRMIConnectionViewRemote clientStub) 
				throws RemoteException;
		
		public void notifyObserver(PutRelative putRelative) throws RemoteException;
		/*public void putRelativeOnTower() throws RemoteException;
		public void putRelativeOnCouncilPalace() throws RemoteException;
		public void putRelativeOnMarket() throws RemoteException;
		public void putRelativeOnHarvestArea() throws RemoteException;
		public void putRelativeOnProductionArea() throws RemoteException;
		public void print() throws RemoteException;*/
		


}
