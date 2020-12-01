package ru.neosvet.lesson6.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.neosvet.lesson6.Server;

import java.io.IOException;

public class Client extends Application {
    public static final String HOST = "localhost";
    private final String PATH_TO_UI = "gui.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(PATH_TO_UI));
        Parent root = loader.load();

        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        ViewController viewController = loader.getController();

        primaryStage.setOnCloseRequest(windowEvent -> viewController.close());
    }

}
