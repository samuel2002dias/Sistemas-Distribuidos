import java.net.*;
//Get the name address of the local machine
public class ex1 {
    public static void main(String args[]) throws Exception {
        InetAddress host = null;
        host = InetAddress.getLocalHost();
        System.out.println(host.getHostName());
    }
}
