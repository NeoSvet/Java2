package ru.neosvet.lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private boolean connected = false;

    public void connect(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        connected = true;
    }

    public void close() {
        try {
            if (connected)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitMessage() {
        Thread thread = new Thread(() -> {
            Client client = null;
            try {
                client = Client.getInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            try {
                while (true) {
                    String message = in.readUTF();
                    if (message.equals("/stop")) {
                        connected = false;
                        client.stopConnection();
                        return;
                    }
                    client.appendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                client.appendErrorMessage(e.getMessage());
            }

        });
        thread.setDaemon(true);
        thread.start();
    }

    public void sendMessage(String msg) throws Exception {
        if (!connected) {
            try {
                Client.getInstance().appendMessage("Message not sent: no connection");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        out.writeUTF(msg);
    }
}

