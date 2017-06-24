package gui;

import java.io.IOException;

import it.polimi.ingsw.client.ClientModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class RegisterClientController {

	@FXML
	private TextField name;
	@FXML
	private ImageView background;
	@FXML
	private Label text;
	@FXML
	private Button button;
	
	private ClientModel client;
	
	
	@FXML
	public void registerClient() {

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

}
