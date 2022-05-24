package core.controllers;

import dto.UserDto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import static utils.ControllerUtils.authLogic;
import static utils.ControllerUtils.switchWindowTo;

public class ControllerReg {

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField emailField;

    @FXML
    private CheckBox isDevCheckBox;

    @FXML
    private TextField nicknameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField walletField;

    @FXML
    void initialize() {
        SignUpButton.setOnAction(event -> {
            int devCode = isDevCheckBox.isSelected() ? 1 : 0;
            if (isFormFilled()) {
                UserDto dto = new UserDto(devCode, nicknameField.getText(),
                        emailField.getText(), passwordField.getText(),
                        Double.valueOf(walletField.getText()));
                authLogic.reg(dto);
                SignUpButton.getScene().getWindow().hide();
                switchWindowTo("mainApp.fxml");
            } else System.out.println("fill fields");
        });
    }

    private boolean isFieldEmpty(TextField field) {
        return !field.getText().trim().equals("");
    }

    private boolean isFormFilled() {
        return isFieldEmpty(emailField) & isFieldEmpty(nicknameField)
                & isFieldEmpty(passwordField) & isFieldEmpty(walletField);
    }
}
