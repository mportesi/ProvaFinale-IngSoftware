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
	
	private Gui gui;
	private ClientRMIConnection client;
	private ClientModel clientModel;
	private String host = "127.0.0.1";
	private int rmi_port = 52365;
	private final String NAME = "LorenzoIlMagnifico";
	/*public WelcomeController(int rmi_port, String host){
		client = new ClientRMIConnection(rmi_port, host);
	}*/
	
	private ServerRMIConnectionViewRemote serverStub;
	
	
	@FXML
	public void rmi(){
		try {
			client = new ClientRMIConnection(rmi_port, host);
			clientModel = new ClientModel();

			Registry registry = LocateRegistry.getRegistry(host, rmi_port);

			ServerRMIConnectionViewRemote serverStub = (ServerRMIConnectionViewRemote) registry.lookup(NAME);


			ClientRMIConnectionView rmiView = new ClientRMIConnectionView(clientModel);
			
			//client.startClient(false);
			Parent page=openNewScene("GuiLogin.fxml");
			
			
			
			
			
			
		} catch (AlreadyBoundException | NullPointerException | NotBoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public Parent openNewScene(String fxml){
	        Parent page=null;
			try {
				page = FXMLLoader.load(WelcomeController.class.getResource(fxml), null, new JavaFXBuilderFactory());
			} catch (IOException e) {
				e.printStackTrace();
			}
			rmi.getScene().setRoot(page);
			return page;
	}
							
}
