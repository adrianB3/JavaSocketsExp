package socket;

import com.sun.security.auth.NTUserPrincipal;

import java.io.*;
import java.net.*;

public class RemotePortScanner {
    public static void main(String[] args){

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        String targetIP = "";
        int fromPort = 0;
        int toPort = 0;

        System.out.println("Target IP: ");
        try {
            targetIP = reader.readLine();
        }
        catch (Exception e){
            System.out.println("Cannot read line" + e.toString());
        }

        boolean isValid = false;

        while(!isValid){
            try{
                System.out.println("Starting Port: ");
                String portString = reader.readLine();
                fromPort = Integer.parseInt(portString);
                if(fromPort >= 0 && fromPort <= 65536){
                    isValid = true;
                }
                else {
                    System.out.println("Out of range!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Please insert a number");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        isValid = false;
        while(!isValid){
            try{
                System.out.println("End Port: ");
                String portString = reader.readLine();
                toPort = Integer.parseInt(portString);
                if(toPort >= 0 && toPort <= 65536 && fromPort <= toPort){
                    isValid = true;
                }
                else {
                    System.out.println("Out of range!");
                }
            }
            catch (NumberFormatException e){
                System.out.println("Please insert a number");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        int currentPort = fromPort;

        while (currentPort >= fromPort && currentPort <= toPort){
            try {
                Socket socket = new Socket(targetIP, currentPort);
                System.out.println("Port " + currentPort + " is open!");
                socket.close();
            } catch (IOException e) {
                System.out.println("Port " + currentPort + " is not open!");
            }
            catch (Exception e){
                e.printStackTrace();
            }

            currentPort++;
        }
    }
}
