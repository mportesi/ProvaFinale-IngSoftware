package gui;

import it.polimi.ingsw.actions.SetServant;
import it.polimi.ingsw.client.ClientModel;
import it.polimi.ingsw.components.Relative;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionView;
import it.polimi.ingsw.serverRMI.ServerRMIConnectionViewRemote;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ServantController {
	private BoardController boardController;
	private Stage stage;
	private Relative relative;
	private ServerRMIConnectionViewRemote serverStub;
	private ClientModel client;
	@FXML
	private TextField servantToUse;
	
	
	@FXML
	public void setValueWithServant() {
		try{
		String valueNew = servantToUse.getText();
		int value = Integer.parseInt(valueNew);
		relative.setValueServant(value);
		SetServant setServant= new SetServant(value, client.getPlayer(), relative, client.getPlayer().getMatch());
		serverStub.notifyObserver(setServant);
		boardController.setValueWithServant(relative, valueNew);
		stage.close();}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setBoardController(BoardController boardController) {
		this.boardController = boardController;
	}

	public void setClientModel(ClientModel client) {
		this.client=client;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setServerRMIConnectionViewRemote(ServerRMIConnectionViewRemote serverStub) {
		this.serverStub = serverStub;
	}

	public void setRelative(Relative relative) {
		this.relative=relative;
		
	}

}
