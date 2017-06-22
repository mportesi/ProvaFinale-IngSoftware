package gui;

import java.io.IOException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.NotBoundException;

import org.json.simple.parser.ParseException;


import it.polimi.ingsw.clientRMI.ClientRMIConnection;
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
	private String host = "127.0.0.1";
	private int rmi_port = 52365;
	
	/*public WelcomeController(int rmi_port, String host){
		client = new ClientRMIConnection(rmi_port, host);
	}*/
	
	@FXML
	public void rmi(){
		try {
			client = new ClientRMIConnection(rmi_port, host);
			client.startClient(false);
			openNewScene("GuiLogin.fxml");
			
		} catch (AlreadyBoundException | NullPointerException | NotBoundException | IOException | ParseException
				| InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void openNewScene(String fxml){
	        Parent page=null;
			try {
				page = FXMLLoader.load(WelcomeController.class.getResource(fxml), null, new JavaFXBuilderFactory());
			} catch (IOException e) {
				e.printStackTrace();
			}
			rmi.getScene().setRoot(page);
	}
							
}
