package org.example.view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.controller.RentalController;
import org.example.model.Unit;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DisplayPropertiesHandler implements Initializable,Runnable {

    @FXML
    private TableColumn<Unit, String> city;

    @FXML
    private TableColumn<Unit, Boolean> isRented;

    @FXML
    private TableColumn<Unit, Double> monthlyRent;

    @FXML
    private TableColumn<Unit, Integer> numberOfBathrooms;

    @FXML
    private TableColumn<Unit, Integer> numberOfBedrooms;

    @FXML
    private TableColumn<Unit, String> postalCode;

    @FXML
    private TableView<Unit> properties;

    @FXML
    private TableColumn<Unit, Integer> squareFootage;

    @FXML
    private TableColumn<Unit, String> streetName;

    @FXML
    private TableColumn<Unit, String> streetNumber;

    @FXML
    private TableColumn<Unit, Integer> unitId;

    @FXML
    private TableColumn<Unit, Integer> unitNumber;
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Unit> units=null;
        new Thread(new Runnable() {
            @Override
            public void run() {
                RentalController rentalController=new RentalController();
                ArrayList<Unit> unitss=rentalController.getProperties();
                ObservableList<Unit> units= FXCollections.observableArrayList(unitss);
                streetName.setCellValueFactory(new PropertyValueFactory<Unit,String>("streetName"));
                unitId.setCellValueFactory(new PropertyValueFactory<Unit,Integer>("unitId"));
                streetNumber.setCellValueFactory(new PropertyValueFactory<Unit,String>("streetNumber"));
                city.setCellValueFactory(new PropertyValueFactory<Unit,String>("city"));
                postalCode.setCellValueFactory(new PropertyValueFactory<Unit,String>("postalCode"));
                isRented.setCellValueFactory(new PropertyValueFactory<Unit,Boolean>("isRented"));
                monthlyRent.setCellValueFactory(new PropertyValueFactory<Unit,Double>("monthlyRent"));
                unitNumber.setCellValueFactory(new PropertyValueFactory<Unit,Integer>("unitNumber"));
                numberOfBedrooms.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("numberOfBedrooms"));
                numberOfBathrooms.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("numberOfBathrooms"));
                squareFootage.setCellValueFactory(new PropertyValueFactory<Unit,Integer>("squareFootage"));

                properties.setItems(units);
            }
        }).start();
    }
    public void onGoBackHandler(ActionEvent e) throws IOException {
        switcher("MainMenu.fxml",e,"Welcome");
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

    @Override
    public void run() {

    }
}
