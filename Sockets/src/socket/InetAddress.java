package socket;

import java.io.*;
import java.net.*;

public class InetAddress {
    public static void main(String[] args){
        try {
            java.net.InetAddress inetAddress = java.net.InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());

            java.net.InetAddress inetAddress1 = java.net.InetAddress.getByName("ligaac.ro");
            System.out.println(inetAddress1.getHostAddress());
            System.out.println(inetAddress1.getHostName());

            var Sock = new Socket(inetAddress1, 9090);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
