package com.ht.view;

import java.io.File;
import java.util.List;

import com.ht.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class MainFrameController {

	@FXML
	private Label social_files;
	@FXML
	private Label tax_files;
	@FXML
	private Label enterprise_files;
	@FXML
	private Label process_status;
	@FXML
	private Label process_info;
	@FXML
	private Button btn_start;
	
	// Reference to the main application.
    private Main mainApp;
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MainFrameController() {
    }
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
      
    }

    private List<File> chooseFiles(String title) {
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle(title);
    	List<File> list = fileChooser.showOpenMultipleDialog(mainApp.getPrimaryStage());
    	
    	return list;
    }
    
    private File chooseDirectory(String title) {        
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle(title);
        File chosenDir = chooser.showDialog(mainApp.getPrimaryStage());
        
        return chosenDir;
    }

    @FXML
    private void handleSocialFiles() {
    	chooseDirectory("社保局数据文件");
    }
    @FXML
    private void handleEnterpriseFiles() {
    	chooseFiles("企业薪资数据文件");
    }
    @FXML
    private void handleTaxFiles() {
    	chooseFiles("税务局数据文件");
    }
}
