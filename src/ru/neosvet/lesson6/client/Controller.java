package ru.neosvet.lesson6.client;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller {
    private SimpleDateFormat timeFormat = new SimpleDateFormat("[HH:mm:ss]");
    @FXML
    private TextField tfMessage;
    @FXML
    private TextArea taChat;
    @FXML
    private ListView lvUsers;

    private String userName = "noname";

    @FXML
    public void initialize() {
        Client.getInstance().ready(this);
        initEventSelectUser();
    }

    private void initEventSelectUser() {
        lvUsers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                userName = newValue;
            }
        });
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
        return timeFormat.format(Calendar.getInstance().getTime());
    }

    public void addUser(String name) {
        lvUsers.getItems().add(name);
    }
}
