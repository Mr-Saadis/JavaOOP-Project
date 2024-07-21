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

public class LungsController {
    User user =User.getUser();
    @FXML
    private AnchorPane lung001;
    @FXML
    private Button lungbtn01;
    @FXML
    private AnchorPane lungbtn1;
    @FXML
    private ImageView close;
    @FXML
    private AnchorPane brain001;
    @FXML
    private Button brainbtn01;
    @FXML
    private Text OSC;
    @FXML
    private Label BloodGroup;
    @FXML
    private Text OSV;
    @FXML
    private Text lungsScoreValue;
    @FXML
    private Text SRC;

    @FXML
    private Text SRV;

    @FXML
    private AnchorPane brainbtn1;
    @FXML
    private AnchorPane heart001;

    @FXML
    private AnchorPane heartbtn1;

    @FXML
    private Button heatbtn01;

    @FXML
    public void initialize() {

        SRV.setText(String.valueOf((int)(user.getLungHealthParameter().getSpirometryResult())));
        OSV.setText(String.valueOf((int)(user.getLungHealthParameter().getOxygenSaturation())));
        SRC.setText(getSRC(user));
        OSC.setText(getOSC(user));
        BloodGroup.setText(user.getHeartHealthParameter().getBloodGroup());
        lungsScoreValue.setText(String.valueOf((int)(user.getLungHealthParameter().getScore())));


        lung001.setOnMouseEntered(event -> slideUp(lungbtn01,lungbtn1));
        lung001.setOnMouseExited(event -> slideDown(lungbtn01,lungbtn1));

        brain001.setOnMouseEntered(event -> slideUp(brainbtn01,brainbtn1));
        brain001.setOnMouseExited(event -> slideDown(brainbtn01,brainbtn1));

        heart001.setOnMouseEntered(event -> slideUp(heatbtn01,heartbtn1));
        heart001.setOnMouseExited(event -> slideDown(heatbtn01,heartbtn1));

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
            //String css = this.getClass().getResource("style.css").toExternalForm();
            //scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            //String css = this.getClass().getResource("style.css").toExternalForm();
            //scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void lungsButton(ActionEvent event) {

    }

    @FXML
    void on_Closed_Clicked(MouseEvent event) {
        Stage stage = (Stage)close.getScene().getWindow();
        stage.close();
    }

    public String getSRC(User user){
        double spirometryResult = user.getLungHealthParameter().getSpirometryResult();
        String score = null;
        if (spirometryResult >= 80) {
            score = "Excellent"; // Excellent
        } else if (spirometryResult >= 70) {
            score = "Good"; // Good
        } else if (spirometryResult >= 60) {
            score = "Fair"; // Fair
        } else {
            score = "Poor"; // Poor
        }
        return score;
    }
    public String getOSC(User user){
        double oxygenSaturation = user.getLungHealthParameter().getOxygenSaturation();
        String score = null;
        // Oxygen Saturation Score
        if (oxygenSaturation >= 95) {
            score = "Excellent"; // Excellent
        } else if (oxygenSaturation >= 90) {
            score = "Good"; // Good
        } else if (oxygenSaturation >= 85) {
            score = "Fair"; // Fair
        } else {
            score = "Poor"; // Poor
        }
        return  score;
    }
}
