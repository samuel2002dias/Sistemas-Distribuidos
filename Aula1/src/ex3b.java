import java.net.*;
import java.io.*;


public class ex3b {
    public static void main(String[] args) throws IOException {
        String s = " ";
        char c;
        System.out.print("Host name?\n");

        while ((c = (char) System.in.read()) != 10)
            s += c;
        s = s.trim();

        InetAddress host = null;

        try {
            host = InetAddress.getByName(s);
            System.out.println("IP: " + host.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Host malformed ");
        }
    }

}
