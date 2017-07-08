package gui;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Quit;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.client.Reconnect;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ReconnectController {
	@FXML
	private Button reconnect;
	
	private BoardController boardController;
	private Stage stage;
	private ServerRMIConnectionViewRemote serverStub;
	private ClientModel client;
	
	public void reconnect(){
		try {
			serverStub.notifyObserver(new Reconnect(client.getPlayer(), client.getPlayer().getMatch()));
		} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
			e.printStackTrace();
		}
		stage.close();
	}
	
	public void setBoardController(BoardController boardController) {
		this.boardController=boardController;
		try {
			serverStub.notifyObserver(new Quit(client.getPlayer(), client.getPlayer().getMatch()));
		} catch (NullPointerException | IOException | ParseException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setStage(Stage stage) {
		this.stage=stage;
	}
	
	public void setClientModel(ClientModel client){
		this.client=client;
	}

	
	public void setServerStub(ServerRMIConnectionViewRemote serverStub) {
		this.serverStub=serverStub;
	}
}
