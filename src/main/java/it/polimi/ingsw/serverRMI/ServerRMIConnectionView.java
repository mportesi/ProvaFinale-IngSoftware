package it.polimi.ingsw.serverRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.InitializeGame;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.RegisterClient;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeNewPlayer;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.serverSocket.ServerView;

public class ServerRMIConnectionView
	extends ServerView implements ServerRMIConnectionViewRemote, Observer<Change> {

		private ArrayList<ClientRMIConnectionViewRemote> clients;



		public ServerRMIConnectionView() {
			this.clients = new ArrayList<>();
		}

		@Override
		public void registerClient(ClientRMIConnectionViewRemote clientStub, String name) throws FileNotFoundException, NullPointerException, IOException, ParseException {
			System.out.println("CLIENT REGISTRATO");
			this.clients.add(clientStub);
			System.out.println(clients.get(0));
			RegisterClient registerClient= new RegisterClient(name);
			this.notifyObserver(registerClient);
		}
		
		@Override
		public void initializeGame() throws FileNotFoundException, NullPointerException, IOException, ParseException{
			InitializeGame initializeGame= new InitializeGame();
			this.notifyObserver(initializeGame);
			System.out.println("notifico di inizializzare");

		}

		@Override
		public void update(Change change) throws FileNotFoundException, NullPointerException, IOException, ParseException {
			System.out.println("SENDING THE CHANGE TO THE CLIENT");
			try {
				System.out.println(change);
				for (ClientRMIConnectionViewRemote clientstub : this.clients) {
					System.out.println("prima update change client");
					clientstub.updateClient(change);
					System.out.println("dopo update change client");
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

		
	}



