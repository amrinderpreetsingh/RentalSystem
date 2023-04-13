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
import org.example.builders.ApartmentBuilder;
import org.example.builders.LeaseBuilder;
import org.example.controller.RentalController;
import org.example.model.Tenant;
import org.example.model.Unit;
import org.example.utilities.Constant;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class RentUnitHandler implements Initializable{
    @FXML
    private Label rightLabel;
    @FXML
    private TextField email;
    @FXML
    private TextField enterChoice;
    @FXML
    private Label bottomLabel;
    @FXML
    private TextField yesOrNo;

    @FXML
    private Label leftLabel;
    @FXML
    private Label topLeft;
    @FXML
    private Button okButton;
    @FXML
    private Button s1Button;
    @FXML
    private Button back1Button;
    private Stage stage;
    private Scene scene;
    private static Tenant tenant;
    private static Unit unit;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(email!=null){

            email.setVisible(false);
            s1Button.setVisible(false);
            back1Button.setVisible(false);
        }

    }
    public void onGoBackHandler(ActionEvent e) throws IOException {
        switcher("MainMenu.fxml",e,"Main Menu");
    }
    public void onSubmitButtonHandler(ActionEvent e) throws IOException {
        String emailId=email.getText();
        rightLabel.setVisible(false);
        RentalController rentalController=new RentalController();
        this.tenant=rentalController.getTenantByEmail(emailId);
        if(tenant!=null){
            switcher("RentUnitScene2.fxml",e,"Rent a Unit");
        }
        else {
            rightLabel.setVisible(true);
            rightLabel.setText("*Wrong Email. Try Again!!!");
        }
        //switcher("PropertyAdded.fxml",e,"Property Added");
    }
     public void yesOrNoButtonHandler(ActionEvent e) throws IOException {
         if(yesOrNo.getText().equalsIgnoreCase("y")){
            leftLabel.setText("Enter Email id");
             s1Button.setVisible(true);
             back1Button.setVisible(true);
             leftLabel.setVisible(true);
             email.setVisible(true);
             yesOrNo.setVisible(false);
             topLeft.setVisible(false);
             okButton.setVisible(false);
         }
         else if(yesOrNo.getText().equalsIgnoreCase("n")){
             switcher("Tenant.fxml",e,"Add a Tenant");
         }
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

    public void onOKButtonHandler(ActionEvent e) throws IOException {
        int choice = Integer.parseInt(enterChoice.getText());
        String type="";
        switch (choice){
            case 1 -> type= Constant.APARTMENT;
            case 2->type=Constant.CONDO;
            case 3->type=Constant.HOUSE;
        }
        if(!type.isEmpty()){

            FXMLLoader fxmlLoader = new FXMLLoader();
            File file=new File("src/main/java/org/example/FXMLFiles/RentApartment.fxml");
            fxmlLoader.setLocation(file.toURI().toURL());
            Parent root=fxmlLoader.load();
            RentApartmentHandler rentApartmentHandler=fxmlLoader.getController();
            rentApartmentHandler.setPropertyType(type);
           SwitchHandler.switcher("RentApartment.fxml",e,"Rent an Apartment");
        }
        else {
            bottomLabel.setText("Wrong Choice. Please select from 1 - 3 only.");
        }
    }
    public void onGoBackHandler1(ActionEvent e) throws IOException {
        switcher("RentUnit.fxml",e,"Rent a Unit");
    }
    public void onGoBackHandler2(ActionEvent e) throws IOException {
        switcher("RentUnitScene2.fxml",e,"Rent a Unit");
    }

    public void setUnit(Unit unit){
        this.unit=unit;
    }

    public void addSubscriber(){
        RentalController rentalController=new RentalController();
        rentalController.subscribeTenantToUnit(unit,tenant);
    }

    public void addLease(String startDateText,String endDateText)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
        Date startDate = null;
        Date endDate=null;
        try {
            startDate = simpleDateFormat.parse(startDateText);
             endDate = simpleDateFormat.parse(endDateText);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        LeaseBuilder leaseBuilder=new LeaseBuilder(unit,tenant,startDate,endDate);
        RentalController rentalController=new RentalController();
        rentalController.addLease(leaseBuilder);
    }
}
