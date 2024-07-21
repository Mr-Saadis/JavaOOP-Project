package project.data.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.data.User;

import java.io.IOException;

public class HomeController {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Circle close;

    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView close1;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button deitBtn;
    @FXML
    private Text BMI_Text;
    @FXML
    private Text totalHealth;

    @FXML
    private Text BMR_Text;

    @FXML
    private Text Calories_Text;

    @FXML
    private Text Fats_Text;

    @FXML
    private Button healthBtn;
    @FXML
    private Label username;
    @FXML
    private Label bloodgroup;
    @FXML
    public void initialize() {
        user = User.getUser();
        String bmr = String.valueOf((int)(user.getBmr().getBmr()));
        int bMi = (int)(user.getBmi().getBmi());
        String bmi = String.valueOf(bMi);
        String calories = String.valueOf(user.getBmr().getMaintainWeightCalories());
        username.setText(user.getFirstname()+" "+user.getLastName());
        bloodgroup.setText(user.getHeartHealthParameter().getBloodGroup());
        totalHealth.setText((int)(user.getTotalScore())+"%");
        Fats_Text.setText(String.valueOf((int)(user.getBmi().getBodyFatPercentage())));


        BMR_Text.setText(bmr);
        BMI_Text.setText(bmi);
        Calories_Text.setText(calories);

         // Create the data series for proteins
        XYChart.Series<String, Number> proteinSeries = new XYChart.Series<>();
        proteinSeries.setName("Protein");
        proteinSeries.getData().add(new XYChart.Data<>("Day 1", 30));
        proteinSeries.getData().add(new XYChart.Data<>("Day 2", 25));
        proteinSeries.getData().add(new XYChart.Data<>("Day 3", 35));

        // Create the data series for fats
        XYChart.Series<String, Number> fatsSeries = new XYChart.Series<>();
        fatsSeries.setName("Fats");
        fatsSeries.getData().add(new XYChart.Data<>("Day 1", 20));
        fatsSeries.getData().add(new XYChart.Data<>("Day 2", 15));
        fatsSeries.getData().add(new XYChart.Data<>("Day 3", 25));

        // Create the data series for carbohydrates
        XYChart.Series<String, Number> carbohydratesSeries = new XYChart.Series<>();
        carbohydratesSeries.setName("Carbohydrates");
        carbohydratesSeries.getData().add(new XYChart.Data<>("Day 1", 50));
        carbohydratesSeries.getData().add(new XYChart.Data<>("Day 2", 60));
        carbohydratesSeries.getData().add(new XYChart.Data<>("Day 3", 40));

        // Add the data series to the chart
        barChart.getData().addAll(proteinSeries, fatsSeries, carbohydratesSeries);

        ///////////
        // Create the data for the pie chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Strength", 30),
                new PieChart.Data("Endurance", 25),
                new PieChart.Data("Flexibility", 20)
               // new PieChart.Data("Balance", 25)
        );

        pieChart.setStartAngle(90);
        pieChart.setClockwise(false);
        pieChart.setLabelsVisible(false);
        //pieChart.setLegendVisible(true);
        // Set the data to the pie chart
        pieChart.setData(pieChartData);
    }

    @FXML
    void onCLickHealth(ActionEvent event) {
        try {
            // Load the CreateMeal.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lungs.fxml"));
            Parent root = loader.load();

            // Get the current stage (window)
            Stage stage = (Stage)healthBtn.getScene().getWindow();



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
    void onClickDeit(ActionEvent event) {
        STATIC_BUTTON staticButton = new STATIC_BUTTON();
        staticButton.Click_Button(pane,"DietPlan.fxml");
    }

    @FXML
    void on_Closed_Clicked(MouseEvent event) {
        Stage stage = (Stage)close1.getScene().getWindow();
        stage.close();
    }

}