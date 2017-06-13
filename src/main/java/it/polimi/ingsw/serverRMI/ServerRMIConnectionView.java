package it.polimi.ingsw.serverRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.InitializeGame;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.RegisterClient;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeInitializePlay;
import it.polimi.ingsw.changes.ChangeNewPlayer;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.serverSocket.ServerView;

public class ServerRMIConnectionView extends ServerView implements ServerRMIConnectionViewRemote, Observer<Change> {

	private ArrayList<ClientRMIConnectionViewRemote> clients;

	public ServerRMIConnectionView() {
		this.clients = new ArrayList<>();
	}

	@Override
	public void registerClient(ClientRMIConnectionViewRemote clientStub, String name)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		//System.out.println("CLIENT REGISTRATO");
		this.clients.add(clientStub);
		//System.out.println(clients.get(0));
		RegisterClient registerClient = new RegisterClient(name);
		// System.out.println("notifico di registerClient() il controller");
		this.notifyObserver(registerClient);
		
		
	}

	@Override
public void verifyNumberOfPlayer()
		throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
	while(clients.size()==1){
		
	}
	if (clients.size() >= 2 && clients.size() < 4) {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {

				System.out.println("sono entrato nel run");
				try {
					initializePlay();

				} catch (NullPointerException | IOException | ParseException e) {

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}, 10 * 1000);// TODO IMPORTARE DA JSON

	}

	else if (clients.size() == 4) {

		initializePlay();
		return;

	}
		  

}

	public void initializePlay()
		throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		InitializeGame initializeGame = new InitializeGame();
		System.out.println("Sto facendo initializePlay");
		this.notifyObserver(initializeGame);
	}

	

	/*@Override
	public void initializeGame(ClientRMIConnectionViewRemote clientStub)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		/*InitializeGame initializeGame = new InitializeGame();
		this.notifyObserver(initializeGame);
		// System.out.println("notifico di initializeGame() il controller");
	}*/
	
	
		

	@Override
	public void update(Change change) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		//System.out.println("SENDING THE CHANGE TO THE CLIENT");
		try {
			//System.out.println(change);
			for (ClientRMIConnectionViewRemote clientstub : this.clients) {
				// System.out.println("sono nel Server prima di fare
				// updateClient(c)");
				clientstub.updateClient(change);
				System.out.println("ho fatto il change sul client " + change);
				// System.out.println("sono nel Server dopo aver fatto
				// updateClient(c)");
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
