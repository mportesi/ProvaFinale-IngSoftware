package it.polimi.ingsw.GC_40;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.actions.RegisterClient;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionViewRemote;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionView;
import it.polimi.ingsw.serverSocket.ServerSocketView;

public class MasterController implements Observer <Action>{
	private HashMap <Integer, Controller> controllers;
	private ArrayList <Play> matches;
	private ArrayList <ClientRMIConnectionViewRemote> clients;
	//private ServerRMIConnectionView serverRMIConnectionView;
	
	public MasterController(){
		
		matches = new ArrayList <Play>();
		clients = new ArrayList <ClientRMIConnectionViewRemote>();
		controllers = new HashMap <Integer, Controller>();
	}
	
	
		
	
	public void checkMatches(ServerRMIConnectionView serverRMIConnectionView, String name) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		if (matches.size() == 0){
			Play play = new Play (0);
			matches.add(play);
			Controller controller = new Controller (play);
			controllers.put(0, controller);
			play.registerObserver(serverRMIConnectionView);
			RegisterClient registerClient = new RegisterClient (name, 0);
			registerClient.apply(play);
		}
		
		else {
			
			if (matches.get(matches.size()-1).getInitializing()){
				RegisterClient registerClient = new RegisterClient (name, matches.size()-1);
				registerClient.apply(matches.get(matches.size()-1));
			}
			else {
				int numberOfMatch = matches.size();
				Play newPlay = new Play (numberOfMatch);
				matches.add(newPlay);
				Controller controller = new Controller (newPlay);
				controllers.put(numberOfMatch, controller);
				newPlay.registerObserver(serverRMIConnectionView);
				RegisterClient registerClient = new RegisterClient (name, numberOfMatch);
				registerClient.apply(newPlay);
			}
		}
		
		
	}
	
	public void checkMatchesSocket(ServerSocketView serverSocketView, String name) throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException{
		if (matches.size() == 0){
			Play play = new Play (0);
			matches.add(play);
			Controller controller = new Controller (play);
			controllers.put(0, controller);
			play.registerObserver(serverSocketView);
			RegisterClient registerClient = new RegisterClient (name, 0);
			registerClient.apply(play);
		}
		
		else {
			
			if (matches.get(matches.size()-1).getInitializing()){
				matches.get(matches.size()-1).registerObserver(serverSocketView);
				RegisterClient registerClient = new RegisterClient (name, matches.size()-1);
				registerClient.apply(matches.get(matches.size()-1));
			}
			else {
				int numberOfMatch = matches.size();
				Play newPlay = new Play (numberOfMatch);
				matches.add(newPlay);
				Controller controller = new Controller (newPlay);
				controllers.put(numberOfMatch, controller);
				newPlay.registerObserver(serverSocketView);
				RegisterClient registerClient = new RegisterClient (name, numberOfMatch);
				registerClient.apply(newPlay);
			}
		}
		
		
	}




	@Override
	public void update(Action action)
			throws FileNotFoundException, NullPointerException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		controllers.get(action.getMatch()).update(action);	
	}




	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
