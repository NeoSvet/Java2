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

                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received message: " + message);
                    if (message.indexOf("/exit") == message.indexOf(">") + 1) {
                        out.writeUTF("/stop");
                        out.flush();
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
        try {
            Scanner scan = new Scanner(System.in);
            do {
                String s = scan.next();
                if (s.equals("/stop"))
                    out.writeUTF(s);
                else
                    out.writeUTF("<Server>" + s);
                out.flush();
            } while (connected);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
