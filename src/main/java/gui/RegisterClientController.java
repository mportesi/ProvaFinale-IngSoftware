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
	private WelcomeController welcomeController;
	
	public ClientModel client;
	public ServerRMIConnectionViewRemote serverStub;
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
		openNewScene();
	}

	@FXML
	public void openNewScene() {
		Parent page = null;
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("GuiFinal.fxml"));
			page =fxmlLoader.load();
			BoardController boardController=fxmlLoader.getController();
			boardController.setClient(client);
			boardController.setPlayer(client.getPlayer());
			boardController.setServerStub(serverStub);
			client.setBoardController(boardController);
		} catch (IOException e) {
			e.printStackTrace();
		}
		name.getScene().setRoot(page);
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
