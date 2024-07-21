package project.data.controllers;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class splashController {
    @FXML
    private AnchorPane splashPane;

    @FXML
    public void initialize() {
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(event -> {
            try {
                Parent homeRoot = FXMLLoader.load(getClass().getResource("UserInfo.fxml"));
                Stage homeStage = new Stage();
                homeStage.initStyle(StageStyle.UNDECORATED);
                homeStage.setScene(new Scene(homeRoot, 1100, 600));
                homeStage.setTitle("Home Screen");
                homeStage.show();

                Stage splashStage = (Stage) splashPane.getScene().getWindow();
                splashStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pause.play();
    }
}