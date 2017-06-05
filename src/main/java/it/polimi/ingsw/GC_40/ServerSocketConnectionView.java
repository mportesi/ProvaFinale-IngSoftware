package it.polimi.ingsw.GC_40;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

import it.polimi.ingsw.colors.ColorPlayer;

public class ServerSocketConnectionView extends ServerView implements Runnable {

	private Socket socket;
	private Scanner socketIn;
	private PrintWriter socketOut;

	public ServerSocketConnectionView(Socket socket) throws IOException {
		this.socket = socket;
		socketIn = new Scanner(socket.getInputStream());
		socketOut = new PrintWriter(socket.getOutputStream());
	}

	public void run() {
		try {
			while (true) {
				
				Player player= new Player();
				System.out.println("SERVER: "+ player);
				String action = socketIn.nextLine();
				System.out.println("SERVER: getting the command " + action);
				
				switch (stringa){
				case "putRelativeOnTower"{
					PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower (//parametri presi da cli e portati qui tramite socket)
							notifyObserver(PutRelative);
							}
				}
				
				//StringTokenizer tokenizer = new StringTokenizer((String) line);

				//Player player=new Player(tokenizer.nextToken());
				
				// System.out.println("SERVER: "+ player);
				// Mossa
				// mossa=Mossa.valueOf(tokenizer.nextToken().toUpperCase());
				// System.out.println("SERVER: "+mossa);
				// Action action=new EseguiMossa(mossa, player);
				// this.setChanged();
				// this.notifyObservers(action);
				if (line.equals("quit")) {
					// exits from the while
					break;
				}
			}
			socketIn.close();
			socketOut.close();
			socket.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void update(){
	}

}
