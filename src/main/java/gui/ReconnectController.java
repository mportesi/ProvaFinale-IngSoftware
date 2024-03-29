package gui;

import java.io.IOException;
import java.io.ObjectOutputStream;

import org.json.simple.parser.ParseException;

import it.polimi.ingsw.actions.Quit;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.actions.Reconnect;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Chiara
 * This class represents the controller of the stage of the reconnection.
 *
 */

public class ReconnectController {
	@FXML
	private Button reconnect;
	
	private BoardController boardController;
	private Stage stage;
	private ServerRMIConnectionViewRemote serverStub;
	private ClientModel client;

	private ObjectOutputStream socketOut;
	
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
			if(serverStub!=null){
			serverStub.notifyObserver(new Quit(client.getPlayer(), client.getPlayer().getMatch()));}
			else if(socketOut!=null){
				socketOut.writeObject(new Quit(client.getPlayer(), client.getPlayer().getMatch()));
			}
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

	public void setSocketOut(ObjectOutputStream socketOut) {
		this.socketOut=socketOut;
		
	}
}
