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
    private static Client it = null;
    private ViewController viewer;
    private Network network;

    public static void main(String[] args) {
        launch(args);
    }

    public static Client getInstance() throws Exception {
        if (it == null)
            throw new Exception("Client is not running!");
        return it;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        it = this;
        Parent root = FXMLLoader.load(getClass().getResource(PATH_TO_UI));
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        primaryStage.setOnCloseRequest(windowEvent -> network.close());
    }

    public void ready(ViewController controller) {
        viewer = controller;
        connect(HOST, Server.PORT);
    }

    public void connect(String localhost, int port) {
        network = new Network();
        try {
            network.connect(localhost, port);
            viewer.putMessage("Connection to server successful");
            network.waitMessage();
        } catch (IOException e) {
            e.printStackTrace();
            viewer.putMessage("Connection to server failed: " + e.getMessage());
        }
    }

    public void appendErrorMessage(String msg) {
        viewer.putMessage("Error: " + msg);
    }

    public void appendMessage(String msg) {
        viewer.putMessage(msg);
    }

    public void sendMessage(String msg) {
        if(msg.equals("/connect")) {
            connect(HOST, Server.PORT);
            return;
        }
        try {
            network.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
            appendErrorMessage(e.getMessage());
        }
    }

    public void stopConnection() {
        viewer.putMessage("Connection interrupted");
    }
}
