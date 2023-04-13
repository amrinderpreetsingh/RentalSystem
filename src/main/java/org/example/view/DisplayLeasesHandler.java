package org.example.view;

import javafx.beans.property.SimpleStringProperty;
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
import org.example.model.Lease;
import org.example.utilities.Constant;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class DisplayLeasesHandler implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private TableColumn<Lease, String> endDate;

    @FXML
    private TableColumn<Lease, Integer> id;

    @FXML
    private TableView<Lease> leases;

    @FXML
    private TableColumn<Lease, Double> monthlyRent;

    @FXML
    private TableColumn<Lease, String> startDate;

    @FXML
    private TableColumn<Lease, String> tenantDetails;

    @FXML
    private TableColumn<Lease, String> unitDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(Constant.DATE_FORMAT);
        RentalController rentalController=new RentalController();
        ArrayList<Lease>leaseArrayList=rentalController.getLeases();
        ObservableList<Lease>leaseObservableList= FXCollections.observableArrayList(leaseArrayList);
        id.setCellValueFactory(new PropertyValueFactory<Lease,Integer>("leaseId"));
        monthlyRent.setCellValueFactory(new PropertyValueFactory<Lease,Double>("monthlyRent"));

        startDate.setCellValueFactory(c->
                new SimpleStringProperty(simpleDateFormat.format(c.getValue().getStartDate())) );
        endDate.setCellValueFactory(c->
                new SimpleStringProperty(simpleDateFormat.format(c.getValue().getEndDate())) );
        unitDetails.setCellValueFactory(cellData->
                new SimpleStringProperty(cellData.getValue().getProperty().toString()));
        tenantDetails.setCellValueFactory(cellData->
                new SimpleStringProperty(cellData.getValue().getTenant().toString()));
        leases.setItems(leaseObservableList);
    }
    public void onOKButtonHandler(ActionEvent e) throws IOException {
        switcher("MainMenu.fxml",e);
    }

    public void switcher(String filename, ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        File file=new File("src/main/java/org/example/FXMLFiles/"+filename);
        fxmlLoader.setLocation(file.toURI().toURL());
        Parent root = fxmlLoader.load();

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root); stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}
