package core;

import javafx.application.Application;
import javafx.stage.Stage;

import static utils.ControllerUtils.switchWindowTo;

public class Main extends Application {
    /**
     * Method in which the main window of the program is launched
     *
     * @param stage new scene variable
     */
    @Override
    public void start(Stage stage) {
        switchWindowTo("start.fxml");
    }

    /**
     * The main method from which the program is launched
     */
    public static void main(String[] args) {
        launch();
    }

}
