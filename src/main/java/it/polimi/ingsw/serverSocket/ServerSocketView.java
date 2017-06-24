package it.polimi.ingsw.serverSocket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.RegisterClientSocket;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.changes.ChangeBuildingCard;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.server.Server;

public class ServerSocketView extends ServerView implements Runnable {
	
	private Socket socket;
	private ObjectInputStream socketIn;
	private ObjectOutputStream socketOut;
	private Server server;
	//private Play model;

	public ServerSocketView(Socket socket, Server server) throws IOException {
		// creates the streams to communicate with the client-side, and the reference to the model
		this.server=server;
		this.socket = socket;
		
		this.socketOut = new ObjectOutputStream(socket.getOutputStream());
		this.socketIn = new ObjectInputStream(socket.getInputStream());
		//this.model=model;
	}

	
	@Override
	public void update(Change o) {
		System.out.println("Sending to the client " + o);
		
		

		// sending the info to the client
		try {
			this.socketOut.reset();
			this.socketOut.writeObject(o);
			this.socketOut.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while (true) {
			// wait for action from the client
			try {

				Object object = socketIn.readObject();
				if (object instanceof Action ) {
					// takes the action from the socket and
					//sends the action to the controller (By notifying it)
					Action action = (Action) object;
					System.out.println("VIEW: received the action " + action);

					this.notifyObserver(action);
				}
				//TODO if for hanling print request 
				if(object instanceof RegisterClientSocket){
					RegisterClientSocket register= (RegisterClientSocket) object;
					String name=register.getName();
					System.out.println("registro il client:" + name);
					registerClient(name);
					
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void registerClient(String name)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		System.out.println("MC: " + server.getMasterController());
		server.getMasterController().checkMatchesSocket(this, name);
		

	}
	

}
