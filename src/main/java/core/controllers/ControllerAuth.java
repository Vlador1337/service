package core.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static utils.ControllerUtils.authLogic;
import static utils.ControllerUtils.switchWindowTo;

public class ControllerAuth {

    @FXML
    private Button authSignInButton;

    @FXML
    private Button authSignUpButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    void initialize() {
        authSignUpButton.setOnAction(event -> {
            switchWindowTo("reg.fxml");
        });


        authSignInButton.setOnAction(event -> {
            if (authLogic.auth(emailField.getText(), passwordField.getText())) {
                switchWindowTo("mainApp.fxml");
            }
        });
    }


}
