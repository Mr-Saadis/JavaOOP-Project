package project.data.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.data.HealthParameter;
import project.data.HeartHealthParameter;
import project.data.User;

public class HeartInfoController {

    private User user;

    public void setUser(User user) {
        this.user = user;
    }
    @FXML
    private TextField BloodGroup;

    @FXML
    private TextField CholestrolLevel;

    @FXML
    private Button Confirm_btn;

    @FXML
    private TextField DYS;

    @FXML
    private TextField HB;

    @FXML
    private TextField PhysicalActivity;

    @FXML
    private TextField SYS;

    @FXML
    private Button back;

    @FXML
    private AnchorPane pane;


    @FXML
    public void initialize(){

        setUpTextField(SYS, DYS);
        setUpTextField(DYS,HB);
        setUpTextField(HB, CholestrolLevel);
        setUpTextField(CholestrolLevel, PhysicalActivity);
        setUpTextField(PhysicalActivity,BloodGroup);
        setUpTextField(BloodGroup,null);
    }

    @FXML
    void On_CLick_Back(ActionEvent event) {
        STATIC_BUTTON staticButton = new STATIC_BUTTON();
        staticButton.Click_Button(pane,"UserInfo.fxml");
    }

    @FXML
    void On_Click_Button(ActionEvent event) {
        if((SYS.getText().isEmpty())||(DYS.getText().isEmpty())||(HB.getText().isEmpty())||(CholestrolLevel.getText().isEmpty())||(PhysicalActivity.getText().isEmpty())||(BloodGroup.getText().isEmpty())){
            Stage stage = (Stage) Confirm_btn.getScene().getWindow();
            Toast.show(stage, "Fill All Blanks!!", 3000);
        }else {
            double Sys = Double.parseDouble(SYS.getText());
            int rhb = Integer.parseInt(HB.getText());
            double chloLevel = Double.parseDouble(CholestrolLevel.getText());
            int PhyActi = Integer.parseInt(PhysicalActivity.getText());
            String BG = BloodGroup.getText();
            HeartHealthParameter heartHealthParameter = new HeartHealthParameter(Sys,rhb,chloLevel,PhyActi,BG);
            user = User.getUser();
            user.setHeartHealthParameter(heartHealthParameter);

            STATIC_BUTTON staticButton = new STATIC_BUTTON();
            staticButton.Click_Button(pane,"LungsInfo.fxml");
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


    @Override
    public String toString() {
        return "HeartInfoController{" +
                "user=" + user +
                '}';
    }
}
