package ru.neosvet.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static final int PORT = 8189;
    private static DataOutputStream out;
    private boolean connected = false;

    public static void main(String[] args) {
        Server server = new Server();
        server.start(PORT);
        server.chat();
    }

    private void chat() {
        try {
            Scanner scan = new Scanner(System.in);
            while (true) {
                String s = scan.next();
                if (s.equals("/stop")) {
                    out.writeUTF(s);
                    out.flush();
                    connected = false;
                    System.out.println("Server stopped");
                    System.exit(0);
                } else if (connected) {
                    out.writeUTF("<Server>" + s);
                    out.flush();
                } else {
                    System.out.println("Message not sent: no connection");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int port) {
        Thread thread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established!");
                connected = true;

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                while (connected) {
                    String message = in.readUTF();
                    System.out.println("Received message: " + message);
                    if (message.indexOf("/exit") == message.indexOf(">") + 1) {
                        connected = false;
                        out.writeUTF("/stop");
                        out.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Port already busy");
                return;
            }

            start(PORT);
        });
        thread.start();
    }
}
