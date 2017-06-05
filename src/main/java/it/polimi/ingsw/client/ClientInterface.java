package it.polimi.ingsw.client;

import java.io.IOException;
import java.util.Scanner;

public interface ClientInterface {
	public void runClient(String name) throws IOException;
	public default void startClient() throws IOException {
		@SuppressWarnings("resource")
		Scanner stdin = new Scanner(System.in);	
		System.out.println("Insert your name:");
		String name = stdin.nextLine();
		this.runClient(name);
	}
	public ConnectionHandler getConnectionHandler();
}
