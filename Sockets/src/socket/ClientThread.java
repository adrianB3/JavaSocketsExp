package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {

    private static int clientNr = 0;
    private int thisClient = 0;
    private Socket socket = null;

    public ClientThread(Socket socket) {
        thisClient = clientNr++;
        this.socket = socket;
    }

    public void run(){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello client");
            boolean isStopped = false;
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(!isStopped){

                String clientInput = in.readLine();
                System.out.println("Client " + thisClient + ": " + clientInput);
                if(clientInput.toUpperCase().equals("STOP"))
                    isStopped = true;
            }
            in.close();
            out.close();
            socket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
