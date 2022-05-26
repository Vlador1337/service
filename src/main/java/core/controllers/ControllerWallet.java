package core.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static utils.ControllerUtils.authLogic;

public class ControllerWallet {

    @FXML
    private Button donateButton;

    @FXML
    private TextField walletDonateField;

    @FXML
    void initialize() {
        donateButton.setOnAction(event -> {
            authLogic.user.setUserWallet(authLogic.user.getUserWallet() +
                    Double.valueOf(walletDonateField.getText()));
            donateButton.getScene().getWindow().hide();
        });
    }
}
