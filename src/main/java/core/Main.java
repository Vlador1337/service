package core;

import javafx.application.Application;
import javafx.stage.Stage;

import static utils.ControllerUtils.switchToMainWindow;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        switchToMainWindow();
    }

    public static void main(String[] args) {
        launch();
    }

}
