package gui;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.clientRMI.ClientRMIConnectionView;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionView;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class RegisterClientController {
	 private String playerName;
	
	 
	@FXML
	private TextField name;
	@FXML
	private ImageView background;
	@FXML
	private Label text;
	@FXML
	private Button button;
	
	@FXML
	private WelcomeController welcomeController;
	
	public ClientModel client;
	public ServerRMIConnectionViewRemote serverStub=new ServerRMIConnectionView();
	public ClientRMIConnectionView rmiView;
	
	
	@FXML
	public void registerClient() throws InterruptedException {
		playerName = text.getText();
		client.setName(playerName);
		try {
			serverStub.registerClient(rmiView, playerName);
		} catch (NullPointerException | IOException | ParseException e) {
			e.printStackTrace();
		} 
		openNewScene("GuiFinal.fxml");
	}

	@FXML
	public void openNewScene(String fxml) {
		Parent page = null;
		try {
			page = FXMLLoader.load(WelcomeController.class.getResource(fxml), null, new JavaFXBuilderFactory());
		} catch (IOException e) {
			e.printStackTrace();
		}
		button.getScene().setRoot(page);
	}

	public void setClient(ClientModel clientModel) {
		this.client=clientModel;	
	}

	public void setServerStub(ServerRMIConnectionViewRemote serverStub) {
		this.serverStub=serverStub;
	}

	public void setClientRMIConnectionView(ClientRMIConnectionView rmiView) {
		this.rmiView=rmiView;
	}

}
