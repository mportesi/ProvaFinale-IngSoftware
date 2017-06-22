package gui;

import it.polimi.ingsw.clientRMI.ClientRMIConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WelcomeController {
	@FXML
	private Label welcome;
	@FXML
	private Label choice;
	@FXML
	private Button socket;
	@FXML
	private Button rmi;
	
	
	private ClientRMIConnection client;
	
	public WelcomeController(int rmi_port, String host){
		client = new ClientRMIConnection(rmi_port, host);
	}
	
	

}
