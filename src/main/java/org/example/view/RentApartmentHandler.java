package org.example.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.controller.RentalController;
import org.example.model.Unit;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RentApartmentHandler implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label errorLabel;
    private static String propertyType;
    @FXML
    private TableColumn<Unit, String> city;

    @FXML
    private TableColumn<Unit, Double> monthlyRent;

    @FXML
    private TableColumn<Unit, Integer> numberOfBathrooms;

    @FXML
    private TableColumn<Unit, Integer> numberOfBedrooms;

    @FXML
    private TableColumn<Unit, String> postalCode;

    @FXML
    private TableColumn<Unit, Boolean> isRented;

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
    @FXML
    private TextField choice;

    @FXML
    private Label startDateLabel;

    @FXML
    private TextField startDateText;

    @FXML
    private Label endDateLabel;

    @FXML
    private TextField endDateText;
    @FXML
    private Button backButton;
    @FXML
    private Button submitButton;
    @FXML
    private Button submitButton1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startDateLabel.setVisible(false);
        startDateText.setVisible(false);
        endDateText.setVisible(false);
        endDateLabel.setVisible(false);
        submitButton1.setVisible(false);
        RentalController rentalController=new RentalController();
        ArrayList<Unit> unitss=rentalController.getPropertiesByType(propertyType);
        ObservableList<Unit> units= FXCollections.observableArrayList(unitss);
        streetName.setCellValueFactory(new PropertyValueFactory<Unit,String>("streetName"));
        unitId.setCellValueFactory(new PropertyValueFactory<Unit,Integer>("unitId"));
        streetNumber.setCellValueFactory(new PropertyValueFactory<Unit,String>("streetNumber"));
        city.setCellValueFactory(new PropertyValueFactory<Unit,String>("city"));
        postalCode.setCellValueFactory(new PropertyValueFactory<Unit,String>("postalCode"));
        monthlyRent.setCellValueFactory(new PropertyValueFactory<Unit,Double>("monthlyRent"));
        isRented.setCellValueFactory(new PropertyValueFactory<Unit,Boolean>("isRented"));
        if(unitss.size()!=0 && !unitss.get(0).getClass().getSimpleName().equals("House")){

            unitNumber.setCellValueFactory(new PropertyValueFactory<Unit,Integer>("unitNumber"));
            numberOfBedrooms.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("numberOfBedrooms"));
            numberOfBathrooms.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("numberOfBathrooms"));
            squareFootage.setCellValueFactory(new PropertyValueFactory<Unit,Integer>("squareFootage"));
        }

        properties.setItems(units);
    }
    public void onOKButtonHandler(ActionEvent e) throws IOException {
        errorLabel.setText("");
        int id = Integer.parseInt(choice.getText());
        RentalController rentalController=new RentalController();
        Unit unit=rentalController.getPropertyById(id);
        if(unit==null){
            errorLabel.setText("You entered wrong id.");
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader();
            File file=new File("src/main/java/org/example/FXMLFiles/RentUnit.fxml");
            fxmlLoader.setLocation(file.toURI().toURL());
            Parent root=fxmlLoader.load();
            RentUnitHandler rentUnitHandler=fxmlLoader.getController();
            rentUnitHandler.setUnit(unit);
            if(unit.getIsRented()){
                 fxmlLoader = new FXMLLoader();
                 file=new File("src/main/java/org/example/FXMLFiles/SubscribeToNotify.fxml");
                fxmlLoader.setLocation(file.toURI().toURL());
                 root=fxmlLoader.load();
                LeaseSubscribeHandler leaseSubscribeHandler=fxmlLoader.getController();
                leaseSubscribeHandler.setUnitData(unit);
               SwitchHandler.switcher("SubscribeToNotify.fxml",e,"Notify");
            }else{
                startDateText.setVisible(true);
                startDateLabel.setVisible(true);
                endDateText.setVisible(true);
                endDateLabel.setVisible(true);
                submitButton1.setVisible(true);
                backButton.setVisible(false);
                submitButton.setVisible(false);

            }

        }

    }
public void onSubmitButton(ActionEvent e) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader();
    File file=new File("src/main/java/org/example/FXMLFiles/RentUnit.fxml");
    fxmlLoader.setLocation(file.toURI().toURL());
    Parent root=fxmlLoader.load();
    RentUnitHandler rentUnitHandler=fxmlLoader.getController();
    rentUnitHandler.addLease(startDateText.getText(),endDateText.getText());
    switcher("LeaseCreated.fxml",e, " Lease Creation");
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

    public void setPropertyType(String type){
        propertyType=type;
    }

    public void backButtonClicked(ActionEvent event) throws IOException {
        switcher("RentUnitScene2.fxml",event,"Property selection");
    }
}
