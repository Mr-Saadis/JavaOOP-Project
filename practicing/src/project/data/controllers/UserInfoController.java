package project.data.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import project.data.Gender;
import project.data.User;


import static project.data.Gender.valueOf;

public class UserInfoController {
    User user= User.getUser();
    @FXML
    private Button Confirm_btn;

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField age;

    @FXML
    private TextField firstName;

    @FXML
    private TextField gender;

    @FXML
    private TextField height;

    @FXML
    private TextField lastName;

    @FXML
    private TextField weight;

    @FXML
    public void initialize(){
        setUpTextField(firstName, lastName);
        setUpTextField(lastName, gender);
        setUpTextField(gender, age);
        setUpTextField(age,weight);
        setUpTextField(weight,height);
        setUpTextField(height,null);
    }

    @FXML
    void on_CLick_Confirm(ActionEvent event) {

        Gender GEnder;
        if (!((gender.getText().toUpperCase().equals("MALE")||(gender.getText().toUpperCase().equals("FEMALE"))))) {
            GEnder = valueOf("OTHER");
        }else{
            GEnder = valueOf(gender.getText().toUpperCase());
        }
        if((firstName.getText().isEmpty())||(lastName.getText().isEmpty())||(age.getText().isEmpty())||(weight.getText().isEmpty())||(height.getText().isEmpty())){
            Stage stage = (Stage) Confirm_btn.getScene().getWindow();
            Toast.show(stage, "Fill All Blanks!!", 3000);
        }else {
            int Age = Integer.parseInt(age.getText());
            double Weight = Double.parseDouble(weight.getText());
            double Height = Double.parseDouble(height.getText());


            HomeController controller = new HomeController();
            controller.setUser(user);

            user.setUserId("001");
            user.setFirstname(firstName.getText());
            user.setLastName(lastName.getText(0,1)+".");
            user.setAge(Age);
            user.setGender(GEnder);
            user.setHeight(Height);
            user.setWeight(Weight);

            STATIC_BUTTON staticButton = new STATIC_BUTTON();
            staticButton.Click_Button(pane,"HeartInfo.fxml");
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