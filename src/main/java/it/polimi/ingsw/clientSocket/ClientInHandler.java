package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;

/**
 * @author Sara
 * This is the class that handle the objects from the server to the client.
 */
public class ClientInHandler implements Runnable {

	private ObjectInputStream socketIn;
	private ClientModel clientModel;
	
	public ClientInHandler(ObjectInputStream socketIn, ClientModel clientModel) {
		this.socketIn=socketIn;
		this.clientModel=clientModel;
		
	}
	/**
	 * @author Sara
	 * When the execute is called, this method is invoked and it starts the connection asking the name to the player
	 * and sending it to the server.
	 */
	@Override
	public void run() {


		while(true){

			// handles input messages coming from the server
			try {
				Object object=socketIn.readObject();
				if (object instanceof Change){
					((Change) object).applyChange(clientModel);

				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		}
	}

