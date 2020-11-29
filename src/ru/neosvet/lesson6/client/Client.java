package ru.neosvet.lesson6.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {
    private final String PATH_TO_UI = "sample.fxml";
    private static Client it = null;
    private Controller controller;

    public static Client getInstance() {
        if (it == null)
            it = new Client(new String[]{});
        return it;
    }

    private Client(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(PATH_TO_UI));
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void ready(Controller controller) {
        controller = controller;
    }
}
