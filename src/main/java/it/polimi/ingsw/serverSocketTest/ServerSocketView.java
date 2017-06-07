package it.polimi.ingsw.serverSocketTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

import it.polimi.ingsw.GC_40.Play;
import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.serverSocket.ServerView;

public class ServerSocketView extends ServerView implements Runnable {
	
	private Socket socket;
	private ObjectInputStream socketIn;
	private ObjectOutputStream socketOut;
	private Play model;

	public ServerSocketView(Socket socket, Play model) throws IOException {
		// creates the streams to communicate with the client-side, and the reference to the model
		this.socket = socket;
		this.socketIn = new ObjectInputStream(socket.getInputStream());
		this.socketOut = new ObjectOutputStream(socket.getOutputStream());
		this.model=model;
	}

	
	@Override
	public void update(Change o) {
		System.out.println("Sending to the client " + o);

		// sending the info to the client
		try {
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
				if (object instanceof Action) {
					// takes the action from the socket and
					//sends the action to the controller (By notifying it)
					Action action = (Action) object;
					System.out.println("VIEW: received the action " + action);

					this.notifyObserver(action);
				}
				//TODO if for hanling print request 

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
