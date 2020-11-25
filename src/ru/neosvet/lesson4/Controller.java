package ru.neosvet.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField tfMessage;
    @FXML
    private TextArea taChat;
    @FXML
    private ListView lvUsers;

    @FXML
    public void initialize() {
        Main.ready(this);
    }

    @FXML
    public void sendMessage(ActionEvent actionEvent) {
        if (tfMessage.getText().isEmpty())
            return;
        String s = tfMessage.getText().trim();
        tfMessage.clear();
        if (s.isEmpty())
            return;
        taChat.setText(taChat.getText() + s + "\n");
    }

    public void addUser(String name) {
        lvUsers.getItems().add(name);
    }
}
