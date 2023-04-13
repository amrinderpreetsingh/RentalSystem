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

import java.io.File;
import java.io.IOException;

public class WhichPropertyHandler {
    @FXML
    private TextField enterChoice;
    @FXML
    private Label topLabel;
    private Stage stage;
    private Scene scene;


    public void onOKButtonHandler(ActionEvent e) throws IOException {
        int choice = Integer.parseInt(enterChoice.getText());
        if(choice==1 ){
            switcher("Apartment.fxml",e,"Add an Apartment");
        }
        else if(choice==2) {
            switcher("Condo.fxml",e,"Add a Condo");
        }
        else if (choice==3) {
            switcher("House.fxml",e,"Add a House");
        }
        else {
            topLabel.setText("Wrong Choice. Please select from 1 - 3 only.");
        }
    }
    public void onGoBackHandler(ActionEvent e) throws IOException {
        switcher("MainMenu.fxml",e,"Main Menu");
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
