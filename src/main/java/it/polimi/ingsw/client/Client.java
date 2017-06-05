package it.polimi.ingsw.client;

import java.util.Scanner;

import java.io.IOException;

public class Client {
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
			ViewClient clientView= new ViewClient();
			input = in.nextInt();
			
			if(input!=1 && input!=2){
				System.out.println("Not valid value inserted");
			}
			else{
				ClientInterface cs = null;
				if(input==1){
					cs = new SocketClient(host, socket, clientView); 
				}
				else{
					//TODO RMI
				}
				cs.startClient();
			}
		}
	}
}

