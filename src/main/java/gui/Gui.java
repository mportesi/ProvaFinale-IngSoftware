package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Chiara
 * This class represents tha main of the GUI.
 *
 */

public class Gui extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	

	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Lorenzo Il Magnifico");

		initRootLayout();
		
		welcome();
	}

	/**
	 * @author Chiara
	 * This method initializes the root layout and show the scene containing it.
	 *
	 */
	public void initRootLayout() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Gui.class.getResource("RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout, 600, 300);
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Chiara
	 * This method initialized the welcome stage.
	 *
	 */
	
	public void welcome() {
		try {
			FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Welcome.fxml"));
			Parent page =fxmlLoader.load();
			rootLayout.setCenter(page);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	

	/**
	 * @author Chiara
	 * This method return the main stage.
	 *
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