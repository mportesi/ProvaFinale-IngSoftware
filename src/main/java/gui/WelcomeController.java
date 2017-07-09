package gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.clientRMI.ClientRMIConnection;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionView;
import it.polimi.ingsw.clientSocket.ClientInHandler;
import it.polimi.ingsw.clientSocket.ClientOutHandler;
import it.polimi.ingsw.clientSocket.ClientSocketConnection;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author Chiara
 * This class represents the controller of the stage of the welcome.
 *
 */

public class WelcomeController {
	
	@FXML
	private Label welcome;
	@FXML
	private Label choice;
	@FXML
	private Button socketButton;
	@FXML
	private Button rmi;
	/*@FXML
	private TextField name;
	@FXML
	private Label text;*/
	
	
	private Gui gui;
	private ClientRMIConnection clientRMI;
	private ClientSocketConnection clientSocket;
	private ClientModel clientModel;
	private String host = "127.0.0.1";
	private int rmi_port = 52365;
	private final String NAME = "LorenzoIlMagnifico";
	private ClientRMIConnectionView rmiView;
	private ServerRMIConnectionViewRemote serverStub;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket;
	
	/*@FXML
	public void registerClient() throws InterruptedException {
		String playerName = name.getText();
		clientModel.setName(playerName);
		try {
			openNewScene();
			serverStub.registerClient(rmiView, playerName);
		} catch (NullPointerException | IOException | ParseException e) {
			e.printStackTrace();
		} 
		
	}*/
	
	@FXML
	public void rmi(){
		try {
			clientRMI = new ClientRMIConnection(rmi_port, host);
			clientRMI.startClient(false);
			serverStub= clientRMI.getServerStub();
			rmiView=clientRMI.getRmiView();
			clientModel=clientRMI.getClientModel();
			openNewScene();
		} catch (AlreadyBoundException | NullPointerException | NotBoundException | IOException | ParseException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void socket(){
		try{
			clientSocket = new ClientSocketConnection();
			clientSocket.startClient(false);
			clientModel=clientSocket.getClientModel();
			out=clientSocket.getObjectOutput();
			in=clientSocket.getObjectInput();
			socket=clientSocket.getSocket();
			clientModel.setCli(false);
			clientModel.setGui(true);
			ExecutorService executor = Executors.newFixedThreadPool(2);
			executor.submit(new ClientOutHandler(out, clientModel, false));
			executor.submit(new ClientInHandler(in, clientModel));
			openNewScene();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@FXML
	public Parent openNewScene(){
	        Parent page=null;
			try {
				FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("GuiLogin.fxml"));
				page =fxmlLoader.load();
				RegisterClientController registerClientController=fxmlLoader.getController();
				registerClientController.setClient(clientModel);
				registerClientController.setClientRMIConnectionView(rmiView);
				registerClientController.setServerStub(serverStub);
				registerClientController.setSocketOut(out);
				registerClientController.setSocketIn(in);
				
				/*BoardController boardController=fxmlLoader.getController();
				boardController.setClient(clientModel);
				boardController.setPlayer(clientModel.getPlayer());
				boardController.setServerStub(serverStub);
				clientModel.setBoardController(boardController);*/
			} catch (IOException e) {
				e.printStackTrace();
				
				return null;
			}
			page.autosize();
			page.relocate(370, 170);
			rmi.getScene().setRoot(page);
			return page;
	}
	
	/*public void putRelative(Action action){
		try {
			serverStub.notifyObserver(action);
		} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
			e.printStackTrace();
		}
	}*/
	/*@FXML
	public void openNewSceneTry(String fxml){
		FXMLLoader fxmlLoader = new FXMLLoader();
		//fxmlLoader.setLocation(getClass().getResource(fxml));
		try {
			Parent page = fxmlLoader.load(WelcomeController.class.getResource(fxml), null, new JavaFXBuilderFactory());
			//AnchorPane frame = fxmlLoader.load();
			rmi.getScene().setRoot(page);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(fxml.equals("GuiLogin.fxml")){
		RegisterClientController registerClient = (RegisterClientController) fxmlLoader.getController();
		registerClient.client=clientModel;
		}
	}*/
							
}
