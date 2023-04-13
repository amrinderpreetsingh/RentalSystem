package org.example.view;

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
import org.example.builders.UnitBuilder;
import org.example.controller.RentalController;

import java.io.File;
import java.io.IOException;

public class HouseHandler {
    @FXML
    private TextField streetNameTextBox;
    @FXML
    private TextField streetNumberTextBox;
    @FXML
    private TextField cityTextBox;
    @FXML
    private TextField postalCodeTextBox;
    @FXML
    private TextField monthlyRentTextBox;
    private Label topLabel;

    private Stage stage;
    private Scene scene;
    UnitBuilder builder = null;

    public HouseHandler() {
        RentalController rentalController = new RentalController();
    }

    public void onSubmitButtonHandler(ActionEvent e) throws IOException {
        String streetName= streetNameTextBox.getText();
        String city = cityTextBox.getText();
        String postalCode = postalCodeTextBox.getText();
        boolean isRented= false;
        String streetNumber = streetNumberTextBox.getText();
        int monthlyRent = Integer.parseInt(monthlyRentTextBox.getText());


        builder = new HouseBuilder(streetName, city, postalCode, isRented, streetNumber, monthlyRent);
        RentalController rentC=new RentalController();
        rentC.addProperty(builder);
        switcher("PropertyAdded.fxml",e,"Property Added");
    }

    public void onGoBackHandler(ActionEvent e) throws IOException {
        switcher("whichProperty.fxml",e,"Add a Property");
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
