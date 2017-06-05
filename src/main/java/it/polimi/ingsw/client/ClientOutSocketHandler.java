package it.polimi.ingsw.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ClientOutSocketHandler implements Runnable{
	private PrintWriter socketOut;
	private ConnectionHandler handler;
	private ViewClient clientView;
	
	public ClientOutSocketHandler(ConnectionHandler handler, ViewClient view){
		//this.socketOut=socketOut;
		this.handler=handler;
		this.clientView=view;
	}

	
	public void run() {
		
		while(true){
			Object action = clientView.start(); //TODO put the player turn choice in ViewClient.start()
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
