package org.example.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.builders.HouseBuilder;
import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.controller.RentalController;

import java.io.File;
import java.io.IOException;

public class TenantHandler {
    @FXML
    private TextField fullNameTextBox;
    @FXML
    private TextField phoneNumberTextBox;
    @FXML
    private TextField emailTextBox;
    private Label topLabel;

    private Stage stage;
    private Scene scene;
    RentalController rentalController;
    TenantBuilder builder = null;

    public void onSubmitButtonHandler(ActionEvent e)  {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String fullName= fullNameTextBox.getText();
                String phoneNumber = phoneNumberTextBox.getText();
                String emailId = emailTextBox.getText();
                builder = new TenantBuilder(fullName,phoneNumber,emailId);
                RentalController rentC=new RentalController();
                rentC.addTenant(builder);
            }
        }).start();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    switcher("TenantAdded.fxml",e,"Tenant Added");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

    }

    public void onGoBackHandler(ActionEvent e) throws IOException {
        switcher("MainMenu.fxml",e,"Main Menu");
    }

    public void switcher(String filename, ActionEvent e ,String title) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        File file=new File("src/main/java/org/example/FXMLFiles/"+filename);
        fxmlLoader.setLocation(file.toURI().toURL());
        Parent root = fxmlLoader.load();

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root); stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
