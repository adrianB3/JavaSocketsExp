package socket;

import java.net.*;
import java.io.*;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args){
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            Socket socket = new Socket(serverAddress, 9090);
            System.out.println(serverAddress.getHostName() + " @ " + serverAddress.getHostAddress());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
            out.println("hello sever");
            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
