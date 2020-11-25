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

    private String userName = "noname";

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
        putMessage(s);
    }

    private void putMessage(String msg) {
        taChat.setText(taChat.getText() + "<" + userName + ">" + msg + "\n");
    }

    public void addUser(String name) {
        lvUsers.getItems().add(name);
    }
}
