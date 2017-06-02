package it.polimi.ingsw.client;

import java.io.PrintWriter;
import java.util.Scanner;

public class ClientOutSocketHandler implements Runnable{
	private PrintWriter socketOut;
	
	public ClientOutSocketHandler(PrintWriter socketOut){
		this.socketOut=socketOut;
	}

	
	public void run() {
		Scanner stdin= new Scanner(System.in);
		
		while(true){
			String inputLine= stdin.nextLine();
			socketOut.println(inputLine);
			socketOut.flush();
		}
		
	}

}
