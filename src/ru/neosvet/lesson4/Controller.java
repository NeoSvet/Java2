package ru.neosvet.lesson4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller {
    private static final String TIME_FORMAT = "[HH:mm:ss]";
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
        taChat.setText(taChat.getText() + getTime() + "<" + userName + ">" + msg + "\n");
    }

    private String getTime() {
        return new SimpleDateFormat(TIME_FORMAT).format(Calendar.getInstance().getTime());
    }

    public void addUser(String name) {
        lvUsers.getItems().add(name);
    }
}
