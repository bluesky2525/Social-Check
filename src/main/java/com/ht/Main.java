package com.ht;
	
import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.ht.view.MainFrameController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;
    private BorderPane rootLayout;
    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("社保基数检查");

        initRootLayout();

        showMainview();
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        rootLayout = new BorderPane();

		// Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showMainview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainFrame.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            
         // Give the controller access to the main app.
            MainFrameController controller = (MainFrameController)loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
