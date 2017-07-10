package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.TimerTask;



import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

/**
 * @author Chiara
 * This class represents the timer for the action.
 *
 */

public class TimerAction extends TimerTask {
	private ServerRMIConnectionViewRemote serverStub;
	
	public TimerAction(ServerRMIConnectionViewRemote serverStub){
		this.serverStub = serverStub;
	}
	
	
	@Override
	public void run() {
		
	}

}
