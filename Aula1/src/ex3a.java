import java.net.*;
import java.io.*;

public class ex3a {

    public static void main(String[] args) throws IOException {
        String s = " ";
        char c;

        System.out.print("IP address? ");

        while ((c = (char) System.in.read()) != 10)
            s += c;
        s = s.trim();

        InetAddress host = null;

        try {
            host = InetAddress.getByName(s);
            System.out.println("Nome: " + host.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("IP malformed ");
        }
    }
}
