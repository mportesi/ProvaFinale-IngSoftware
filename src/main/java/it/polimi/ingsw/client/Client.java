package it.polimi.ingsw.client;

import java.util.Scanner;

import it.polimi.ingsw.GC_40.Player;
import it.polimi.ingsw.clientSocket.ClientInterface;
import it.polimi.ingsw.clientSocket.ClientSocket;
import it.polimi.ingsw.clientSocket.ClientSocketConnection;

import java.io.IOException;

public class Client {
	private Player player;
	
	public static void main(String[] args) throws IOException{
		
		Scanner in = new Scanner(System.in);
		String host = "127.0.0.1";
		int socket = 29999;
		
		System.out.println("Welcome to Lorenzo il Magnifico \n");
		System.out.println("Select how you want to play:\n");
		System.out.println("1) Command Line Interface (CLI)");
		System.out.println("2) Graphical User Interface (GUI)");
		
		int input = in.nextInt();
		if(input==1){
			System.out.println("Select your connection:\n");
			System.out.println("1) Socket");
			System.out.println("2) Remote Method Invocation (RMI)");
			input = in.nextInt();
			
			if(input!=1 && input!=2){
				System.out.println("Not valid value inserted");
			}
			else{
				
				if(input==1){
					ClientSocketConnection client = new ClientSocketConnection(host, socket, clientView); 
					ClientSocket cs = new ClientSocket(); 
					cs.startClient();
				}
				else{
					//TODO RMI
				}
				client.startClient();
			}
		}
	}

	public void setPlayer(Player player) {
		// TODO Auto-generated method stub
		this.player=player;
		
	}
}

