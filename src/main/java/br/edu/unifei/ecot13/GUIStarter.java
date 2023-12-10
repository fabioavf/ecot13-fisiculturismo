package br.edu.unifei.ecot13;

import java.net.URL;

import br.edu.unifei.ecot13.controller.AtletaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIStarter extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL path = getClass().getResource("view/view.fxml");
        System.err.println(path);
        FXMLLoader fxmlLoader = new FXMLLoader(path);

        Parent root = fxmlLoader.load();
        Scene screen = new Scene(root);

        primaryStage.setTitle("Fisiculturismo");
        primaryStage.setScene(screen);
        primaryStage.show();
    }
}
