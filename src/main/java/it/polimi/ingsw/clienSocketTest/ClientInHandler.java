package it.polimi.ingsw.clienSocketTest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class ClientInHandler implements Runnable {

	private ObjectInputStream socketIn;
	
	public ClientInHandler(ObjectInputStream socketIn) {
		this.socketIn=socketIn;
	}
	
	@Override
	public void run() {


		while(true){

			// handles input messages coming from the server
			try {
				Object object=socketIn.readObject();
				//TODO insert if for change, like if(object.getClass().equals(SomeChange.class)) --> modify the client model
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
