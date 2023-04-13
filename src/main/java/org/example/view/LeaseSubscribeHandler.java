package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.model.Unit;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaseSubscribeHandler implements Initializable {
    @FXML
    private Label cityLabel;

    @FXML
    private Label monthlyRentLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label streetNameLabel;

    @FXML
    private Button submitButton;
    @FXML
    private Button mainMenuButton;

    @FXML
    private Label msg;
    @FXML
    private Label streetNumberLabel;
    @FXML
    private TextField textField;
    private static Unit unit;

    private Stage stage;
    private Scene scene;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainMenuButton.setVisible(false);
        msg.setVisible(false);
        if(unit!=null){
            streetNameLabel.setText(unit.getStreetName());
            streetNumberLabel.setText(unit.getStreetNumber());
            cityLabel.setText(unit.getCity());
            monthlyRentLabel.setText(unit.getMonthlyRent()+"");
            postalCodeLabel.setText(unit.getPostalCode());
        }
    }
    @FXML
    public void onSubmitButtonHandler(ActionEvent event) throws IOException {
        String choice=textField.getText();
        if(choice.equalsIgnoreCase("Y")){
            mainMenuButton.setVisible(true);
            msg.setVisible(true);
            FXMLLoader fxmlLoader = new FXMLLoader();
            File file=new File("src/main/java/org/example/FXMLFiles/RentUnit.fxml");
            fxmlLoader.setLocation(file.toURI().toURL());
            Parent root=fxmlLoader.load();
            RentUnitHandler rentUnitHandler=fxmlLoader.getController();
            rentUnitHandler.addSubscriber();
            submitButton.setVisible(false);
        }else {
            switcher("MainMenu.fxml",event,"Main Menu");
        }
    }

    @FXML
    public void mainMenuClicked(ActionEvent event) throws IOException {
        switcher("MainMenu.fxml", event,"Main Menu");
    }
    public void setUnitData(Unit unit){
        this.unit=unit;
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
}
