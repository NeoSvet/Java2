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
                System.out.println("Ожидание подключения...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Соединение установлено!");

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                while (true) {
                    String message = in.readUTF();
                    System.out.println("Сообщение пользователя: " + message);

                    if (message.equals("/exit")) {
                        break;
                    }

                    out.writeUTF(message.toUpperCase());
                }

                System.out.println("Сервер остановлен");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Порт уже занят");
            }
        });
        thread.start();
    }
}
