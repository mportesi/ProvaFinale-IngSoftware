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
		playerName = name.getText();
		client.setName(playerName);
		System.out.println(playerName);
		try {
			openNewScene();
			serverStub.registerClient(rmiView, playerName);
			System.out.println("the name is" + client.getPlayer().getName());
			
		} catch (NullPointerException | IOException | ParseException e) {
			e.printStackTrace();
		} 
		
	}

	@FXML
	public void openNewScene() {
		Parent page = null;
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("GuiFinal.fxml"));
			page =fxmlLoader.load();
			BoardController boardController=fxmlLoader.getController();
			boardController.setClient(client);
			System.out.println("the name is" + playerName);
			boardController.setPlayer(client.getPlayer());
			boardController.setServerStub(serverStub);
			client.setBoardController(boardController);
			System.out.println(boardController.getClient());
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
