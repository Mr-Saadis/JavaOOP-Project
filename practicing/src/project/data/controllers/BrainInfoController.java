package project.data.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.data.*;

public class BrainInfoController {
    User user;

    @FXML
    private TextField CholeconjectivefunctionstrolLevel;

    @FXML
    private Button Confirm_btn;


    @FXML
    private Button back;

    @FXML
    private TextField mental;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField sleep;

    @FXML
    public void initialize(){

        setUpTextField(CholeconjectivefunctionstrolLevel,sleep);
        setUpTextField(sleep,mental);
        setUpTextField(mental,null);
    }

    @FXML
    void On_CLick_Back(ActionEvent event) {
        STATIC_BUTTON staticButton = new STATIC_BUTTON();
        staticButton.Click_Button(pane,"UserInfo.fxml");
    }

    @FXML
    void On_Click_Button(ActionEvent event) {
        if((CholeconjectivefunctionstrolLevel.getText().isEmpty())||(mental.getText().isEmpty())||(sleep.getText().isEmpty())){
            Stage stage = (Stage) Confirm_btn.getScene().getWindow();
            Toast.show(stage, "Fill All Blanks!!", 3000);
        }else {
            int CFL = Integer.parseInt(CholeconjectivefunctionstrolLevel.getText());
            int Sleep = Integer.parseInt(sleep.getText());
            int Mental = Integer.parseInt(mental.getText());

            BrainHealthParameter brainhealthparameter = new BrainHealthParameter(CFL,Sleep,Mental);
            user = User.getUser();
            user.setBrainHealthParameter(brainhealthparameter);

            CalculateBMR calBMR = new CalculateBMR();
            CalculateBMI calBMI = new CalculateBMI();

            user.CreateReport();

            STATIC_BUTTON staticButton = new STATIC_BUTTON();
            staticButton.Click_Button(pane,"home.fxml");

        }
    }
    private void setUpTextField(TextField current, TextField next) {
        current.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")) {
                if (next != null) {
                    next.requestFocus();
                }else {
                    ActionEvent event1= new ActionEvent();
                    On_Click_Button(event1);
                }
                event.consume();
            }
        });
    }
}