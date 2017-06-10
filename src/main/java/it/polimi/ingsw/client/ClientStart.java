package it.polimi.ingsw.client;

import java.util.ArrayList;

public class ClientStart {
	/*private ArrayList<ClientStart> clients;
	private ClientModel clientModel;

	public ClientModel start() throws InterruptedException {
		
		
		/*while (clients.size() < 2) {
			clients.get(0).wait();
		}
		while (clients.size() <= 3) {
			Long timeout = (long) 10000; // TODO IMPORTARE TIMEOUT
			clients.wait(timeout);
		}
		if (clients.size() <=4) {
			clientModel = new ClientModel();

		}*/
		/*long timeout= 10000000;
		long startTime = System.currentTimeMillis();
		while(clients.size()<=2 || (System.currentTimeMillis()-startTime)<timeout){
			return clientModel;}
		return null;
	}*/
	/*if (clients == null) {
		clients = new ArrayList<>();
		clients.add(this);
	} else {
		clients.add(this);
	}
	long timeout = 10000000;
	long startTime = System.currentTimeMillis();
	while (clients.size() <= 2 || (System.currentTimeMillis() - startTime) < timeout) {
		System.out.println("sto aspettando");
	}
	if (clients.size() == 2) {
		clientModel = new ClientModel();
		System.out.println(clientModel);
	}*/

}
