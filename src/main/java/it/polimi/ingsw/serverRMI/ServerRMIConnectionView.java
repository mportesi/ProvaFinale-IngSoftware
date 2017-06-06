package it.polimi.ingsw.serverRMI;

import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Set;

import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.serverSocket.ServerView;

public class ServerRMIConnectionView
	extends ServerView implements ServerRMIConnectionViewRemote {

		private Set<ClientRMIConnectionViewRemote> clients;



		public ServerRMIConnectionView() {
			this.clients = new HashSet<>();
		}

		@Override
		public void registerClient(ClientRMIConnectionViewRemote clientStub) throws RemoteException {
			System.out.println("CLIENT REGISTRATO");
			this.clients.add(clientStub);
		}

		@Override
		public void update(Change change) {
			System.out.println("SENDING THE CHANGE TO THE CLIENT");
			try {
				for (ClientRMIConnectionViewRemote clientstub : this.clients) {
					
					clientstub.updateClient(change);
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void notifyObserver(PutRelative putRelative){
			this.notifyObserver(putRelative);
		}

		

		/*public void turnOn() throws RemoteException{
			this.notifyObserver(new TurnOn());
		}

		public void turnOff() throws RemoteException{
			this.notifyObserver(new TurnOff());

		}

		public void scommetti() throws RemoteException{
			this.notifyObserver(new Scommetti());
		}

		public void printModel() throws RemoteException{
			this.notifyObserver(new PrintModel());
		}

		*/
	}


