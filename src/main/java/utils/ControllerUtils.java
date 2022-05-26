package utils;

import core.Auth;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Vlador1337
 * Class designed for interact with the user interface
 */
public class ControllerUtils {
    public static Auth authLogic = new Auth();
    public static Stage stage = new Stage();
    public static Stage stageWallet = new Stage();

    /**
     * switching windows GUI
     *
     * @param fxml open fxml file(Scene)
     */
    public static void switchWindowTo(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(ControllerUtils.class.getClassLoader().getResource(fxml));
            stage.setTitle("VladorShop");
            stage.setScene(new Scene(loader.load(), 1280, 720));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void switchWindowTo(String fxml, int width, int height) {
        try {
            FXMLLoader loader = new FXMLLoader(ControllerUtils.class.getClassLoader().getResource(fxml));
            stageWallet.setTitle("Wallet");
            stageWallet.setScene(new Scene(loader.load(), width, height));
            stageWallet.setResizable(false);
            stageWallet.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
