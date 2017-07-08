package gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.RegisterClientSocket;
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
	public ObjectOutputStream socketOut;
	public ObjectInputStream socketIn;
	
	
	
	@FXML
	public void registerClient() throws InterruptedException {
		playerName = name.getText();
		client.setName(playerName);
		try {
			openNewScene();
			if(serverStub!=null){
			serverStub.registerClient(rmiView, playerName);}
			if(socketOut!=null && socketIn!=null){
			RegisterClientSocket register=new RegisterClientSocket(playerName);
			socketOut.writeObject(register);
			socketOut.flush();}
		} catch (NullPointerException | IOException | ParseException e) {
			e.printStackTrace();
		} 
		
	}
// 2 uramaki hollor 1 uramaki philadelphia 1 hossomaki ebiten ebiyaky meshi tempura di verdure yaki udon
	@FXML
	public void openNewScene() {
		Parent page = null;
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("GuiFinal.fxml"));
			page =fxmlLoader.load();
			BoardController boardController=fxmlLoader.getController();
			boardController.setClient(client);
			boardController.setServerStub(serverStub);
			boardController.setSocketOut(socketOut);
			client.setBoardController(boardController);
			text.getScene().setRoot(page);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	public void setSocketOut(ObjectOutputStream out) {
		this.socketOut=out;
	}
	public void setSocketIn(ObjectInputStream in){
		this.socketIn=in;
	}

}
