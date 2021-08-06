package lesson6.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static ServerSocket server;
    static Socket socket;
    private static final int PORT = 1408;

    public static void main(String[] args) {
        Server server = new Server();
    }
          public Server() {

            try {

                server = new ServerSocket(PORT);
                System.out.println("Server started");
                socket = server.accept();
                System.out.println("Client connected ");

                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner sc = new Scanner(System.in);


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            System.out.println("input your message");
                            String msg = sc.nextLine();
                            System.out.println("send accepted");
                            out.println(msg);
                        }
                    }
                }).start();

                while (true) {
                    String msg = in.nextLine();
                    if (msg.equals("/end"))
                        break;
                    System.out.println("Client: " + msg);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    server.close();
                    System.out.println("Server stopped");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


