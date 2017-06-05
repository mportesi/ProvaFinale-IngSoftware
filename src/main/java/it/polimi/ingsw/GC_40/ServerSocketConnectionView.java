package it.polimi.ingsw.GC_40;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

import it.polimi.ingsw.actions.PutRelativeOnCouncilPalace;
import it.polimi.ingsw.actions.PutRelativeOnHarvestArea;
import it.polimi.ingsw.actions.PutRelativeOnMarket;
import it.polimi.ingsw.actions.PutRelativeOnProductionArea;
import it.polimi.ingsw.actions.PutRelativeOnTower;
import it.polimi.ingsw.changes.Change;
import it.polimi.ingsw.colors.ColorPlayer;
import it.polimi.ingsw.components.PrivilegeCouncil;

public class ServerSocketConnectionView extends ServerView implements Runnable {

	private Socket socket;
	private Scanner socketIn;
	private PrintWriter socketOut;

	public ServerSocketConnectionView(Socket socket) throws IOException {
		this.socket = socket;
		socketIn = new Scanner(socket.getInputStream());
		socketOut = new PrintWriter(socket.getOutputStream());
	}

	@Override
	public void update(Change change) {
		// TODO Auto-generated method stub
		change.applyChange();

	}

	public void run() {
		try {
			while (true) {

				Player player = new Player();
				System.out.println("SERVER: " + player);
				String action = socketIn.nextLine();
				System.out.println("SERVER: getting the command " + action);
<<<<<<< HEAD
				
				switch (stringa){
				case "putRelativeOnTower"{
					PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower (//parametri presi da cli e portati qui tramite socket)
							notifyObserver(PutRelative);
							}
				}
				
				//StringTokenizer tokenizer = new StringTokenizer((String) line);
=======
				String parameters = socketIn.nextLine();
>>>>>>> Sara

				switch (action) {
				case "putRelativeOnTower": {
					PutRelativeOnTower putRelativeOnTower = new PutRelativeOnTower(/* parametri */);
					this.notifyObserver(putRelativeOnTower);
					break;
				}
				case "putRelativeOnMarket": {
					PutRelativeOnMarket putRelativeOnMarket = new PutRelativeOnMarket(/* parametri */);
					this.notifyObserver(putRelativeOnMarket);
					break;
				}
				case "putRelativeOnHarvestArea": {
					PutRelativeOnHarvestArea putRelativeOnHarvestArea = new PutRelativeOnHarvestArea(/* parametri */);
					this.notifyObserver(putRelativeOnHarvestArea);
					break;
				}
				case "putRelativeOnProductionArea": {
					PutRelativeOnProductionArea putRelativeOnProductionArea = new PutRelativeOnProductionArea(/* parametri */);
					this.notifyObserver(putRelativeOnProductionArea);
					break;
				}
				case "putRelativeOnCouncilPalace": {
					PutRelativeOnCouncilPalace putRelativeOnCouncilPalace = new PutRelativeOnCouncilPalace(/* parametri */);
					this.notifyObserver(putRelativeOnCouncilPalace);
					break;

				}
				
				}
			}
			socketIn.close();
			socketOut.close();
			socket.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		socketOut.flush();
	}
	

<<<<<<< HEAD
	@Override
	public void update(){
=======
	/*@Override
	public void update(Observable o, Object arg) {
		System.out.println("SERVER-VIEW-SOCKET: sending the client the message: " + arg);
		socketOut.println("SERVER: " + arg);
		socketOut.flush();
	}*/

	@Override
	public void update() {
		// TODO Auto-generated method stub

>>>>>>> Sara
	}

}
