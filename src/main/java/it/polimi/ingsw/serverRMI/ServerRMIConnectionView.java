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
import it.polimi.ingsw.server.Server;
import it.polimi.ingsw.serverSocket.ServerView;

public class ServerRMIConnectionView extends ServerView implements ServerRMIConnectionViewRemote, Observer<Change> {

	private volatile ArrayList<ClientRMIConnectionViewRemote> clients;
	private Server server;

	public ServerRMIConnectionView(Server server) {
		this.server = server;
		this.clients = new ArrayList<>();
	}

	@Override
	public void registerClient(ClientRMIConnectionViewRemote clientStub, String name)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		this.clients.add(clientStub);
		System.out.println("MC: " + server.getMasterController());
		server.getMasterController().checkMatches(this, name);
		

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
