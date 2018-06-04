package socket;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args)
    {
        while(true){
            try {
                var serverSocket = new ServerSocket(9090);
                System.out.println("Waiting for clients");
                boolean isStopped = false;
                while(!isStopped){
                    var socket = serverSocket.accept();
                    System.out.println("Client is connected.");
                    ClientThread ct = new ClientThread(socket);
                    ct.start();
                }
                serverSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}