package it.polimi.ingsw.clientSocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClientOutSocketHandler implements Runnable{
	private ConnectionHandler handler;
	private ClientView clientView;
	
	public ClientOutSocketHandler(ConnectionHandler handler, ClientView view){
		//this.socketOut=socketOut;
		this.handler=handler;
		this.clientView=view;
	}

	
	public void run() {
		
		while(true){
			Object action = clientView.start(); //TODO put the player turn choice in ClientView.start()
			if(action!=null){
				try{
					handler.sendToServer(action);
				}catch (IOException e) {
					if(e.getMessage().equals("Socket closed"))
					System.out.println("THE GAME IS FINISHED, BYE BYE");
					break;
				} catch (IllegalArgumentException | IllegalStateException c){
					System.out.println("Error in performing action: "+c.getMessage());
				}
			}
		}
		
	}

}