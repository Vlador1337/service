package core.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static utils.ControllerUtils.switchToMainWindow;

public class ControllerMainApp {

    @FXML
    private Button exitButton;

    @FXML
    private Button libButton;

    @FXML
    private Button shopButton;

    @FXML
    void initialize() {
        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            switchToMainWindow();
        });
    }
}
