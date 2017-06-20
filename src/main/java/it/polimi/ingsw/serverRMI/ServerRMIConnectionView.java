package it.polimi.ingsw.serverRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Controller;
import it.polimi.ingsw.GC_40.Observer;
import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.InitializeGame;
import it.polimi.ingsw.actions.PutRelative;
import it.polimi.ingsw.actions.RegisterClient;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeInitializePlay;
import it.polimi.ingsw.changes.ChangeNewPlayer;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.server.Server;
import it.polimi.ingsw.serverSocket.ServerView;

public class ServerRMIConnectionView extends ServerView implements ServerRMIConnectionViewRemote, Observer<Change> {

	private volatile ArrayList<ClientRMIConnectionViewRemote> clients;
	private Server server;
	private ArrayList<Play> matches;
	

	public ServerRMIConnectionView(Server server) {
		this.clients = new ArrayList<>();
		this.server=server;
		matches = new ArrayList <Play>();
	}

	@Override
	public void registerClient(ClientRMIConnectionViewRemote clientStub, String name)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
<<<<<<<
		
		if(clients.size()<4){
			Play play=new Play(0);
			Controller controller = new Controller (play);
			server.getMasterController().addController(controller, 0);
=======

>>>>>>>
		this.clients.add(clientStub);
		RegisterClient registerClient = new RegisterClient(name);
		this.notifyObserver(registerClient);

	}


	@Override
	public void update(Change change)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		try {
			for (ClientRMIConnectionViewRemote clientstub : this.clients) {
				clientstub.updateClient(change);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {

	}

}
