package lesson6.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static final String SERVER_ADDRESS = "localhost";
    static final int SERVER_PORT = 1408;

    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String msg = in.nextLine();
                        System.out.println("Server: " + msg);
                    }
                }
            }).start();


            while (true) {
                System.out.println("Write you message...");
                String msg = sc.nextLine();

                out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

