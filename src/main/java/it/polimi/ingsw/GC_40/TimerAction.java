package it.polimi.ingsw.GC_40;

import java.io.IOException;
import java.util.TimerTask;

import com.sun.tools.example.debug.expr.ParseException;

import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class TimerAction extends TimerTask {
	private ServerRMIConnectionViewRemote serverStub;
	
	public TimerAction(ServerRMIConnectionViewRemote serverStub){
		this.serverStub = serverStub;
	}
	@Override
	public void run() {
		System.out.println("It ran out of time!");
		ShiftPlayer shiftPlayer = new ShiftPlayer();
		try {
			serverStub.notifyObserver(shiftPlayer);
		} catch (NullPointerException | IOException | InterruptedException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}

}
