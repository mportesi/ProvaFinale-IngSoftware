package it.polimi.ingsw.serverRMI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.ConnectException;
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
import it.polimi.ingsw.changes.ChangeNewPlayer;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.server.Server;
import it.polimi.ingsw.serverSocket.ServerView;

public class ServerRMIConnectionView extends ServerView implements ServerRMIConnectionViewRemote, Observer<Change> {

	private volatile ArrayList<ClientRMIConnectionViewRemote> clients;
	private Server server;
	private ClientRMIConnectionViewRemote clientDisconnected;

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
			boolean d=false;
			for (ClientRMIConnectionViewRemote clientstub : this.clients) {
				try{clientstub.updateClient(change);}
				catch(RemoteException e){
					clientDisconnected=clientstub;
					d=true;
					break;
			
					}
				}
			/*if(d){
				updateDisconnected(change);
			}*/
		} 
	

	/*public void updateDisconnected(Change change){
		ArrayList<ClientRMIConnectionViewRemote> clients1= new ArrayList<>();
		clients1=clients;
		clients.remove(clientDisconnected);
		for(ClientRMIConnectionViewRemote client: clients){
			try {
				client.updateClient(change);
			} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			server.getMasterController().disconnect(client);
		}}*/
	
	@Override
	public void update() {

	}

}
