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

public class ViewController {
    private SimpleDateFormat timeFormat = new SimpleDateFormat("[HH:mm:ss]");
    @FXML
    private TextField tfMessage;
    @FXML
    private TextArea taChat;
    @FXML
    private ListView lvUsers;

    private String userName = "noname";
    private Client client;

    @FXML
    public void initialize() {
        initEventSelectUser();
        try {
            client = Client.getInstance();
            client.ready(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        String msg = tfMessage.getText().trim();
        if (msg.isEmpty())
            return;
        msg = "<" + userName + ">" + msg;
        try {
            client.sendMessage(msg);
            tfMessage.clear();
            putMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void putMessage(String msg) {
        if (taChat.getText().isEmpty())
            taChat.setText(getTime() + msg + "\n");
        else
            taChat.setText(taChat.getText() + getTime() + msg + "\n");
    }

    private String getTime() {
        return timeFormat.format(Calendar.getInstance().getTime());
    }

    public void addUser(String name) {
        lvUsers.getItems().add(name);
    }
}