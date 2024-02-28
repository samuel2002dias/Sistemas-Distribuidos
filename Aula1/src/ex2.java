
import java.net.*;

//Get the IP address of the local machine
public class ex2 {
    public static void main(String args[]) throws Exception {
        InetAddress host = null;
        host = InetAddress.getLocalHost();
        byte ip[] = host.getAddress();
        for (int i = 0; i < ip.length; i++) {
            if (i > 0)
                System.out.print(".");
            System.out.print(ip[i] & 0xff);
        }
        System.out.println();
    }
}
