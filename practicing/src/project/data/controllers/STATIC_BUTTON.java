package project.data.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class STATIC_BUTTON {
     public void  Click_Button(AnchorPane pane,String Screen){
        try {
            // Load the CreateMeal.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Screen));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage)pane.getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }
}
