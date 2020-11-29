package ru.neosvet.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8189;

    public static void main(String[] args) {
        Server server = new Server();
        server.start(PORT);
    }

    public void start(int port) {
        Thread thread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established!");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received message: " + message);
                    if (message.equals("/exit")) {
                        break;
                    }
                }

                System.out.println("Server stopped");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Port already busy");
            }
        });
        thread.start();
    }
}
