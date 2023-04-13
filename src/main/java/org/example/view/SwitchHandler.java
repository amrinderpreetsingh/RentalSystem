package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SwitchHandler {
    private static Stage stage;
    private static Scene scene;

    public static void switcher(String filename, ActionEvent e, String title) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        File file = new File("src/main/java/org/example/FXMLFiles/" + filename);
        fxmlLoader.setLocation(file.toURI().toURL());
        Parent root = fxmlLoader.load();

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
