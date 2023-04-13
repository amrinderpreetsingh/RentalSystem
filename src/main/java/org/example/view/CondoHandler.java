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
import org.example.builders.ApartmentBuilder;
import org.example.builders.CondoBuilder;
import org.example.builders.UnitBuilder;
import org.example.controller.RentalController;

import java.io.File;
import java.io.IOException;

public class CondoHandler {
    @FXML
    private TextField streetName;
    @FXML
    private TextField streetNumber;
    @FXML
    private TextField city;
    @FXML
    private TextField postalCode;
    @FXML
    private TextField monthlyRent;
    @FXML
    private TextField bedrooms;
    @FXML
    private TextField bathrooms;
    @FXML
    private TextField squareFootage;
    @FXML
    private TextField unitNumber;
    @FXML
    private Label topLabel;

    private Stage stage;
    private Scene scene;
    RentalController rentalController;
    UnitBuilder builder = null;

    public CondoHandler() {
        RentalController rentalController = new RentalController();
    }

    public void onSubmitButtonHandler(ActionEvent e) throws IOException {
        String stName= streetName.getText();
        String ct = city.getText();
        String pCode = postalCode.getText();
        boolean isRented= false;
        String stNumber = streetNumber.getText();
        int rent = Integer.parseInt(monthlyRent.getText());
        int nBedrooms= Integer.parseInt(bedrooms.getText());
        int nBathrooms=Integer.parseInt(bathrooms.getText());
        int sqFootage=Integer.parseInt(squareFootage.getText());
        String uNumber = unitNumber.getText();
        builder = new CondoBuilder(stName, ct, pCode, isRented, stNumber, rent, nBedrooms, nBathrooms, sqFootage, uNumber);
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
