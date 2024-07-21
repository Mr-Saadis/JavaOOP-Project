package project.data.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.data.Gender;
import project.data.User;

public class DietController {
    User user= User.getUser();
    private double bmi;
    private double bmr;
    @FXML
    private Text SCORE;
    @FXML
    private Text BMIConditions;
    @FXML
    private Text BMRConditions;
    @FXML
    private Text fatsConditions;
    @FXML
    private Text BMI_label;
    @FXML
    private Text BMR_label;
    @FXML
    private TextField age;
    @FXML
    private Button back;
    @FXML
    private Button calculate;
    @FXML
    private Text bmrValue;
    @FXML
    private Text bmivalue;
    @FXML
    private ImageView close;
    @FXML
    private Label Blood;
    @FXML
    private Text fats;
    @FXML
    private TextField height;
    @FXML
    private Text toGain;
    @FXML
    private Text toLoss;
    @FXML
    private Text toMaintain;
    @FXML
    private TextField weight;
    @FXML
    private AnchorPane pane;


    @FXML
    void goBack(ActionEvent event) {
        STATIC_BUTTON staticButton = new STATIC_BUTTON();
        staticButton.Click_Button(pane,"home.fxml");
    }

    @FXML
    void on_Closed_Clicked(MouseEvent event) {
        Stage stage = (Stage)close.getScene().getWindow();
        stage.close();
    }

    @FXML
    void on_calculate(ActionEvent event) {
        if((age.getText().isEmpty()&&height.getText().isEmpty()&&weight.getText().isEmpty())){
            Stage stage = (Stage) calculate.getScene().getWindow();
            Toast.show(stage, "Fill All Blanks!!", 3000);
        }else {
            bmi = (Double.parseDouble(weight.getText())/ Double.parseDouble(height.getText())/ Double.parseDouble(height.getText()))*10000;

            if (user.getGender() == Gender.MALE) {
                bmr = 88.362 + (13.397 * Double.parseDouble(weight.getText())) + (4.799 * Double.parseDouble(height.getText())) - (5.677 * Double.parseDouble(age.getText()));
            } else {
                bmr = 447.593 + (9.247 * Double.parseDouble(weight.getText())) + (3.098 * Double.parseDouble(height.getText())) - (4.330 * Double.parseDouble(age.getText()));
            }
            BMI_label.setText(String.valueOf((int)(bmi)));
            BMR_label.setText(String.valueOf((int)(bmr)));
        }

    }
    @FXML
    public void initialize() {
        toGain.setText(String.valueOf(user.getBmr().getGainWeightCalories()));
        toMaintain.setText(String.valueOf(user.getBmr().getMaintainWeightCalories()));
        toLoss.setText(String.valueOf(user.getBmr().getLoseWeightCalories()));
        Blood.setText(user.getHeartHealthParameter().getBloodGroup());
        SCORE.setText(String.valueOf((int)((user.getBmr().getScore()+user.getBmi().getScore())/2)));
        fatsConditions.setText(getFat(user));
        BMIConditions.setText(getBMICondition(user));
        BMRConditions.setText(getBMRCondition(user));
        fats.setText(String.valueOf((int)(user.getBmi().getBodyFatPercentage())));
        bmrValue.setText(String.valueOf((int)(user.getBmr().getBmr())));
        bmivalue.setText(String.valueOf((int)(user.getBmi().getBmi())));

    }
    public String getFat(User user){
        double bodyFatPercentage = user.getBmi().getBodyFatPercentage();
        String score = null;
        if (bodyFatPercentage >= 6 && bodyFatPercentage < 14) {
            score = "Excellent"; // Excellent for men
        } else if (bodyFatPercentage >= 14 && bodyFatPercentage < 18) {
            score = "Good"; // Good for men
        } else if (bodyFatPercentage >= 18 && bodyFatPercentage < 25) {
            score = "Average"; // Average for men
        } else if (bodyFatPercentage >= 25 && bodyFatPercentage < 31) {
            score = "Below"; // Below average for men
        } else if (bodyFatPercentage >= 31 && bodyFatPercentage <= 40) {
            score = "Poor"; // Poor for men
        } else if (bodyFatPercentage < 6 || bodyFatPercentage > 40) {
            score = "Worst"; // Extremely poor for men
        }
        return score;
    }
    public String getBMICondition(User user){
        double bmi = user.getBmi().getBmi();
        String score = null;
        if (bmi >= 18.5 && bmi < 25) {
            score = "Normal"; // Normal weight
        } else if (bmi >= 25 && bmi < 30) {
            score = "Overweight"; // Overweight
        } else if (bmi >= 30 && bmi < 35) {
            score = "Obesity I"; // Obesity class I
        } else if (bmi >= 35 && bmi < 40) {
            score = "Obesity II"; // Obesity class II
        } else if (bmi >= 40) {
            score = "Obesity III"; // Obesity class III
        } else {
            score += 10; // Underweight
        }
        return score;
    }

    public String getBMRCondition(User user){
        double bmr = user.getBmr().getBmr();
        String score = null;
        if (bmr >= 1200 && bmr <= 1800) {
            score = "Optimal"; // Optimal range
        } else if ((bmr > 1800 && bmr <= 2200) || (bmr > 1000 && bmr < 1200)) {
            score = "Slightly above"; // Slightly above or below optimal range
        } else if ((bmr > 2200 && bmr <= 2500) || (bmr >= 800 && bmr <= 1000)) {
            score = "Moderately above"; // Moderately above or below optimal range
        } else {
            score = "Worst"; // Far from optimal range
        }
        return score;
    }

}