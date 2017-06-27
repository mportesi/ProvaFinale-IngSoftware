package gui;

import java.io.IOException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

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
	@FXML
	private TextField name;
	@FXML
	private Label text;
	@FXML
	private Button button;
	
	private Gui gui;
	private ClientRMIConnection client;
	private ClientModel clientModel;
	private String host = "127.0.0.1";
	private int rmi_port = 52365;
	private final String NAME = "LorenzoIlMagnifico";
	private ClientRMIConnectionView rmiView;
	private ServerRMIConnectionViewRemote serverStub;
	
	@FXML
	public void registerClient() throws InterruptedException {
		String playerName = name.getText();
		clientModel.setName(playerName);
		try {
			serverStub.registerClient(rmiView, playerName);
		} catch (NullPointerException | IOException | ParseException e) {
			e.printStackTrace();
		} 
		openNewScene("GuiFinal.fxml");
	}
	
	@FXML
	public void rmi(){
		try {
			/*client = new ClientRMIConnection(rmi_port, host);
			clientModel = new ClientModel();

			Registry registry = LocateRegistry.getRegistry(host, rmi_port);

			ServerRMIConnectionViewRemote serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);


			ClientRMIConnectionView rmiView = new ClientRMIConnectionView(clientModel);
			
			*/
			client = new ClientRMIConnection(rmi_port, host);
			client.startClient(false);
			serverStub= client.getServerStub();
			rmiView=client.getRmiView();
			clientModel=client.getClientModel();
			//openNewSceneTry("GuiLogin.fxml");
			
			
			
		} catch (AlreadyBoundException | NullPointerException | NotBoundException | IOException | ParseException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public Parent openNewScene(String fxml){
	        Parent page=null;
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
			try {
				page = fxmlLoader.load();
				BoardController boardController=fxmlLoader.getController();
				boardController.setClient(clientModel);
				clientModel.setBoardController(boardController);
			} catch (IOException e) {
				e.printStackTrace();
			}
			rmi.getScene().setRoot(page);
			return page;
	}
	
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
