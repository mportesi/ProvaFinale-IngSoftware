package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Gui extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Lorenzo Il Magnifico");

		initRootLayout();
		welcome();
		register();
		//showBoard();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Gui.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showBoard() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Gui.class.getResource("GuiFinal.fxml"));
			AnchorPane board = (AnchorPane) loader.load();
			// imageView board=(ImageView) AnchorPane.getChildren().get(0)

			rootLayout.setCenter(board);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void welcome() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Gui.class.getResource("Welcome.fxml"));
			AnchorPane welcome = (AnchorPane) loader.load();
			rootLayout.setCenter(welcome);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void register() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Gui.class.getResource("GuiLogin.fxml"));
			AnchorPane login = (AnchorPane) loader.load();
			// imageView board=(ImageView) AnchorPane.getChildren().get(0)

			rootLayout.setCenter(login);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);

	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}
}