package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.TimerTask;

import com.sun.tools.example.debug.expr.ParseException;

import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class TimerAction extends TimerTask {
	private ServerRMIConnectionViewRemote serverStub;
	
	public TimerAction(ServerRMIConnectionViewRemote serverStub){
		this.serverStub = serverStub;
	}
	
	public void input(){
		CommandLineInterface cli= new CommandLineInterface();
		
	}
	@Override
	public void run() {
		/*System.out.println("It ran out of time!");
		ShiftPlayer shiftPlayer = new ShiftPlayer();
		try {
			serverStub.notifyObserver(shiftPlayer);
		} catch (NullPointerException | IOException | InterruptedException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}*/
	}

}
