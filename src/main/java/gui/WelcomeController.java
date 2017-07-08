package gui;

import java.io.IOException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Action;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.clientRMI.ClientRMIConnection;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionView;
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

public class WelcomeController {
	
	@FXML
	private Label welcome;
	@FXML
	private Label choice;
	@FXML
	private Button socket;
	@FXML
	private Button rmi;
	/*@FXML
	private TextField name;
	@FXML
	private Label text;*/
	
	
	private Gui gui;
	private ClientRMIConnection client;
	private ClientModel clientModel;
	private String host = "127.0.0.1";
	private int rmi_port = 52365;
	private final String NAME = "LorenzoIlMagnifico";
	private ClientRMIConnectionView rmiView;
	private ServerRMIConnectionViewRemote serverStub;
	
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
			client = new ClientRMIConnection(rmi_port, host);
			client.startClient(false);
			serverStub= client.getServerStub();
			rmiView=client.getRmiView();
			clientModel=client.getClientModel();
			openNewScene();
		} catch (AlreadyBoundException | NullPointerException | NotBoundException | IOException | ParseException | InterruptedException e) {
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
				/*BoardController boardController=fxmlLoader.getController();
				boardController.setClient(clientModel);
				boardController.setPlayer(clientModel.getPlayer());
				boardController.setServerStub(serverStub);
				clientModel.setBoardController(boardController);*/
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
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
