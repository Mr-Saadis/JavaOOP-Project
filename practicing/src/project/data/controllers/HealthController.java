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

public class HealthController {
    User user = User.getUser();
    @FXML
    private AnchorPane lung001;
    @FXML
    private ImageView close;
    @FXML
    private Text BPC;

    @FXML
    private Text BPV;
    @FXML
    private Label BloodGroup;

    @FXML
    private Text HeartScoreV;
    @FXML
    private Text CLC;

    @FXML
    private Text CLV;

    @FXML
    private Text HRC;

    @FXML
    private Text HRV;
    @FXML
    private Button lungs01;

    @FXML
    private AnchorPane lung1;
    @FXML
    private AnchorPane brain001;

    @FXML
    private Button brain01;

    @FXML
    private AnchorPane brain1;
    @FXML
    private AnchorPane heart001;

    @FXML
    private AnchorPane heart1;

    @FXML
    private Button heart01;

    @FXML
    public void initialize() {

        BPV.setText(String.valueOf((int)(user.getHeartHealthParameter().getBloodPressure())));
        BPC.setText(getBPC(user));
        HRV.setText(String.valueOf(user.getHeartHealthParameter().getRestingHeartRate()));
        HRC.setText(getHRC(user));
        CLV.setText(String.valueOf((int)(user.getHeartHealthParameter().getCholesterolLevel())));
        CLC.setText(getCLC(user));
        BloodGroup.setText(user.getHeartHealthParameter().getBloodGroup());
        HeartScoreV.setText(String.valueOf((int)(user.getHeartHealthParameter().getScore())));

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
    private Button back;

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
        try {
            // Load the CreateMeal.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Brain.fxml"));
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
    void heartButton(ActionEvent event) {

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
    public String getBPC(User user){
        double bloodPressure = user.getHeartHealthParameter().getBloodPressure();
        String score= null;
        if (bloodPressure < 120) {
            score = "Normal"; // Normal
        } else if (bloodPressure < 130) {
            score = "Elevated"; // Elevated
        } else if (bloodPressure < 140) {
            score = "Hypertention I"; // Hypertension Stage 1
        } else if (bloodPressure < 180) {
            score ="Hypertention II"; // Hypertension Stage 2
        } else {
            score = "Hypertensive Crisis"; // Hypertensive Crisis
        }
        return score;
    }
    public String getHRC(User user){
        int restingHeartRate = user.getHeartHealthParameter().getRestingHeartRate();
        String score =null;
        // Resting Heart Rate Score
        if (restingHeartRate < 60) {
            score = "Excellent"; // Excellent
        } else if (restingHeartRate < 70) {
            score = "Good"; // Good
        } else if (restingHeartRate < 80) {
            score = "Average"; // Average
        } else if (restingHeartRate < 90) {
            score = "Below Average"; // Below Average
        } else {
            score = "Poor"; // Poor
        }
        return  score;
    }
    public String getCLC(User user){
        double cholesterolLevel = user.getHeartHealthParameter().getCholesterolLevel();
        String score = null;
        // Cholesterol Level Score
        if (cholesterolLevel < 200) {
            score = "Desirable"; // Desirable
        } else if (cholesterolLevel < 240) {
            score = "BorderLine High"; // Borderline High
        } else {
            score = "High"; // High
        }
        return score;
    }
}