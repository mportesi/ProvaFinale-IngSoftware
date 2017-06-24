package it.polimi.ingsw.GC_40;

import java.util.Scanner;
import java.util.concurrent.Callable;

import it.polimi.ingsw.actions.ShiftPlayer;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.json.JsonTimeOut;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;

public class TimerActionTry implements Callable<String>{
	private ServerRMIConnectionViewRemote serverStub;
	private  ClientModel clientModel;
	private Thread thread;
	
	public TimerActionTry(ServerRMIConnectionViewRemote serverStub, ClientModel clientModel, Thread thread){
		this.serverStub=serverStub;
		this.clientModel=clientModel;
		this.thread=thread;
	}

	@Override
	public String call() throws Exception {
		JsonTimeOut jsonTimeOut = new JsonTimeOut();
		int timeOutAction = jsonTimeOut.getTimeOutAction();
		Thread.sleep((long) timeOutAction*100);
		thread.stop();
		System.out.println("It's run out of time");
		ShiftPlayer shiftPlayer = new ShiftPlayer(clientModel.getPlayer().getMatch());
		serverStub.notifyObserver(shiftPlayer);
		return "It's run out of time";
	}
	

}
