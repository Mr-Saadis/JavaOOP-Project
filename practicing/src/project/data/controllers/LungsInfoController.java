package project.data.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import project.data.HealthParameter;
import project.data.LungHealthParameter;
import project.data.User;

public class LungsInfoController {
    User user=User.getUser();

    @FXML
    private Button Confirm_btn;

    @FXML
    private Button back;

    @FXML
    private TextField osl;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField smoker;

    @FXML
    private TextField spirometry;


    @FXML
    public void initialize(){

        setUpTextField(spirometry,osl);
        setUpTextField(osl,smoker);
        setUpTextField(smoker,null);
    }

    @FXML
    void On_CLick_Back(ActionEvent event) {
        STATIC_BUTTON staticButton = new STATIC_BUTTON();
        staticButton.Click_Button(pane,"HeartInfo.fxml");

    }

    @FXML
    void on_CLick_Confirm(ActionEvent event) {
        if((spirometry.getText().isEmpty()||(osl.getText().isEmpty()))){

        }else {
            boolean IsSmoker;
            if(smoker.getText().toUpperCase().equals("YES")){
                IsSmoker = true;
            }else {
                IsSmoker = false;
            }
            double SPIRATORY = Double.parseDouble(spirometry.getText());
            double ROSL = Double.parseDouble(osl.getText());

            LungHealthParameter lungHealthParameter = new LungHealthParameter(SPIRATORY,ROSL,IsSmoker);
            user.setLungHealthParameter(lungHealthParameter);

            STATIC_BUTTON staticButton = new STATIC_BUTTON();
            staticButton.Click_Button(pane,"BrainInfo.fxml");
        }
    }
    private void setUpTextField(TextField current, TextField next) {
        current.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER")) {
                if (next != null) {
                    next.requestFocus();
                }else {
                    ActionEvent event1= new ActionEvent();
                    on_CLick_Confirm(event1);
                }
                event.consume();
            }
        });
    }
}
