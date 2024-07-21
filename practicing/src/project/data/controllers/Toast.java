package project.data.controllers;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;

import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Toast {

    public static void show(Stage ownerStage, String message, int durationInMillis) {
        Popup popup = new Popup();
        popup.setAutoFix(true);
        popup.setAutoHide(true);
        popup.setHideOnEscape(true);
        popup.setX(650);
        popup.setY(600);

        Label label = new Label(message);
        label.setStyle("-fx-background-color: #f11224; -fx-text-fill: white; -fx-padding: 10px;");
        popup.getContent().add(label);

        popup.show(ownerStage);

        FadeTransition fadeOut = new FadeTransition(Duration.millis(durationInMillis), label);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> popup.hide());
        fadeOut.play();
    }
}
