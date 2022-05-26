package core.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static utils.ControllerUtils.authLogic;
import static utils.ControllerUtils.switchWindowTo;

public class ControllerShop {

    @FXML
    private Button exitButton;

    @FXML
    private Button libButton;

    @FXML
    private Button walletButton;

    @FXML
    private Label walletField;

    @FXML
    private Label nicknameField;

    @FXML
    void initialize() {
        walletField.setText("Кошелёк: " + authLogic.user.getUserWallet() + " р.");
        nicknameField.setText(authLogic.user.getUserName() + " ");

        exitButton.setOnAction(event -> {
            switchWindowTo("start.fxml");
        });
        libButton.setOnAction(event -> {
            switchWindowTo("lib.fxml");
        });
        walletButton.setOnAction(event -> {
            switchWindowTo("wallet.fxml", 400, 241);
        });
    }
}
