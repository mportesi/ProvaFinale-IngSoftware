package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.client.ClientModel;

public class ClientInHandler implements Runnable {

	private ObjectInputStream socketIn;
	private ClientModel clientModel;
	
	public ClientInHandler(ObjectInputStream socketIn, ClientModel clientModel) {
		this.socketIn=socketIn;
		this.clientModel=clientModel;
		
	}
	
	@Override
	public void run() {


		while(true){

			// handles input messages coming from the server
			try {
				Object object=socketIn.readObject();
				System.out.println("ricevuto oggetto");
				if (object instanceof Change){
					System.out.println("ricevuto change");
					((Change) object).applyChange(clientModel);
					System.out.println(" change apply");

				}
				//TODO insert if for change, like if(object.getClass().equals(SomeChange.class)) --> modify the client model
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
