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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.controller.RentalController;
import org.example.model.Tenant;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class DisplayTenantsHandler implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    private TableColumn<Tenant, String> email;

    @FXML
    private TableColumn<Tenant, String> fullName;

    @FXML
    private TableColumn<Tenant, Double> monthlyRent;

    @FXML
    private TableColumn<Tenant, String> phoneNumber;
    @FXML
    private TableView<Tenant> tenants;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RentalController rentalController=new RentalController();
        ArrayList<Tenant>tenantArrayList=rentalController.getTenants();
        ObservableList<Tenant>tenant= FXCollections.observableArrayList(tenantArrayList);
        email.setCellValueFactory(new PropertyValueFactory<Tenant,String>("email"));
        fullName.setCellValueFactory(new PropertyValueFactory<Tenant,String>("fullName"));
        email.setCellValueFactory(new PropertyValueFactory<Tenant,String>("email"));
        monthlyRent.setCellValueFactory(new PropertyValueFactory<Tenant,Double>("monthlyRent"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Tenant,String>("phoneNumber"));
        tenants.setItems(tenant);
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
