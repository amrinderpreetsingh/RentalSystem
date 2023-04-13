package org.example.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class MainMenuHandler {
    @FXML
    private TextField enterChoice;
    private Stage stage;
    private Scene scene;


    public void onOKButtonHandler(ActionEvent e) throws IOException {
        int choice = Integer.parseInt(enterChoice.getText());
        if(choice==1){
            switcher("whichProperty.fxml",e,"Add a Property");
        }else if(choice==2){
            switcher("Tenant.fxml",e,"Add a Tenant");
        }
        else if(choice==3){
            switcher("RentUnit.fxml",e,"Rent a Unit");
        }
        else if (choice==4) {
            switcher("DisplayProperties.fxml",e,"Displaying all Properties");
        } else if (choice==5) {
            switcher("DisplayTenants.fxml",e,"Displaying all Tenant");
        } else if (choice==6) {
            switcher("DisplayRentedProperties.fxml",e,"Displaying rented Properties");
        } else if (choice==7) {
            switcher("DisplayVacantProperties.fxml",e,"Displaying vacant Properties");
        } else if (choice==8) {
            switcher("DisplayLeases.fxml",e,"Displaying Leases");
        }
        else if(choice==9){
            logout(e);
        }
    }
    public void onGoBackHandler(ActionEvent e) throws IOException {
        switcher("MainView.fxml",e,"Welcome");
    }
    public void switcher(String filename, ActionEvent e,String title) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        File file=new File("src/main/java/org/example/FXMLFiles/"+filename);
        fxmlLoader.setLocation(file.toURI().toURL());
        Parent root = fxmlLoader.load();

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root); stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    public void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you really want to exit? ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have successfully logged out!");
            Platform.exit();
        }
    }
}

