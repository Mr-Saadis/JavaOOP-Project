package project.data.controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import project.data.User;

import java.io.IOException;

public class BrainController {
    User user = User.getUser();

    @FXML
    private Button back;
    @FXML
    private ImageView close;
    @FXML
    private AnchorPane brain001;
    @FXML
    private Text CFCondition;

    @FXML
    private Text MHCondition;

    @FXML
    private Text SQCondition;
    @FXML
    private Button brain01;

    @FXML
    private AnchorPane brain1;

    @FXML
    private AnchorPane heart001;

    @FXML
    private Button heart01;

    @FXML
    private AnchorPane heart1;

    @FXML
    private AnchorPane lung001;

    @FXML
    private AnchorPane lung1;

    @FXML
    private Button lungs01;
    @FXML
    private Label BloodGroup;

    @FXML
    private Text BrainScoreV;
    @FXML
    public void initialize() {

        SQCondition.setText(getSleepCondition(user));
        MHCondition.setText(getMentalCondition(user));
        CFCondition.setText(getcognitiveCOndition(user));
        BloodGroup.setText(user.getHeartHealthParameter().getBloodGroup());
        BrainScoreV.setText(String.valueOf((int)(user.getBrainHealthParameter().getScore())));


        lung001.setOnMouseEntered(event -> slideUp(lungs01,lung1));
        lung001.setOnMouseExited(event -> slideDown(lungs01,lung1));

        brain001.setOnMouseEntered(event -> slideUp(brain01,brain1));
        brain001.setOnMouseExited(event -> slideDown(brain01,brain1));

        heart001.setOnMouseEntered(event -> slideUp(heart01,heart1));
        heart001.setOnMouseExited(event -> slideDown(heart01,heart1));

    }




    private void slideUp(Button btn1, AnchorPane btn2) {
        btn1.setVisible(true);
        btn2.setVisible(true);

        TranslateTransition transitionBtn01 = new TranslateTransition(Duration.millis(300), btn1);
        transitionBtn01.setToY(-3); // Move up by 42 units

        TranslateTransition transitionBtn1 = new TranslateTransition(Duration.millis(300), btn2);
        transitionBtn1.setToY(-3); // Move up by 42 units

        transitionBtn01.play();
        transitionBtn1.play();
    }

    private void slideDown(Button btn1, AnchorPane btn2) {
        TranslateTransition transitionBtn01 = new TranslateTransition(Duration.millis(300), btn1);
        transitionBtn01.setToY(20); // Move back to original position
        transitionBtn01.setOnFinished(event -> btn1.setVisible(false));

        TranslateTransition transitionBtn1 = new TranslateTransition(Duration.millis(300), btn2);
        transitionBtn1.setToY(20); // Move back to original position
        transitionBtn1.setOnFinished(event -> btn2.setVisible(false));

        transitionBtn01.play();
        transitionBtn1.play();
    }
    @FXML
    void goBack(ActionEvent event) {
        try {
            // Load the CreateMeal.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) back.getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void brainButton(ActionEvent event) {


    }

    @FXML
    void heartButton(ActionEvent event) {
        try {
            // Load the CreateMeal.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Health.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) back.getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void lungsButton(ActionEvent event) {
        try {
            // Load the CreateMeal.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lungs.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage) back.getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void on_Closed_Clicked(MouseEvent event) {
        Stage stage = (Stage)close.getScene().getWindow();
        stage.close();
    }

    public String getcognitiveCOndition(User user){
        int cognitiveFunctionScore = user.getBrainHealthParameter().getCognitiveFunctionScore();
        String score = null;
        if (cognitiveFunctionScore >= 90) {
            score = "Excellent"; // Excellent
        } else if (cognitiveFunctionScore >= 75) {
            score = "Good"; // Good
        } else if (cognitiveFunctionScore >= 60) {
            score = "Average"; // Average
        } else if (cognitiveFunctionScore >= 40) {
            score = "Below Average"; // Below Average
        } else {
            score = "Poor"; // Poor
        }
        return score;
    }

    public String getSleepCondition(User user){
        // Sleep Quality Score
        int sleepQualityScore = user.getBrainHealthParameter().getSleepQualityScore();
        String score= null;
        if (sleepQualityScore >= 90) {
            score = "Ecellent"; // Excellent
        } else if (sleepQualityScore >= 75) {
            score = "Good"; // Good
        } else if (sleepQualityScore >= 60) {
            score = "Average"; // Average
        } else {
            score = "Poor"; // Poor
        }
        return score;
    }

    public String getMentalCondition(User user){
        // Mental Health Score
        int mentalHealthScore = user.getBrainHealthParameter().getMentalHealthScore();
        String score = null;
        if (mentalHealthScore >= 90) {
            score = "Excellent"; // Excellent
        } else if (mentalHealthScore >= 75) {
            score = "Good"; // Good
        } else if (mentalHealthScore >= 60) {
            score = "Average"; // Average
        } else {
            score = "Poor"; // Poor
        }
        return score;
    }


}
