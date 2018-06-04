package socket;
import java.io.*;
import java.net.*;

public class LocalPortScanner {

    public static void main(String[] args) {

        int portCount = 1;
        while(portCount <= 65535){
            try {
                ServerSocket socket = new ServerSocket(portCount++);
            } catch (IOException e) {
                System.out.println("The port "+ portCount +" is already open!");
            }
        }
    }

}
