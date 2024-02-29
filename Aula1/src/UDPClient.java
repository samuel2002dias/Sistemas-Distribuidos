import java.net.*;
import java.io.*;
public class UDPClient {
    public static String readString() {
        BufferedReader canal;
        canal = new BufferedReader(new InputStreamReader(System.in));
        try {
            return canal.readLine();
        } catch (IOException ex) {
            return null;
        }
        
    }

    public static void main(String args[]) throws SocketException {
        String s;
        System.out.print("Qual o servidor? ");
        String host = readString();
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            aSocket.setSoTimeout(10000); // Exercício c)
            while (true) {
                System.out.print("<Client> Mensagem a enviar = ");
                s = readString();

                if (s.equals("fim")) { // Exercício d)
                    break;
                } ;


                byte[] m = s.getBytes();
                InetAddress aHost = InetAddress.getByName(host);
                int serverPort = 2222;

                DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);

                long start = System.currentTimeMillis(); //Exercício e)

                aSocket.send(request);

                byte[] buffer = new byte[100];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);

                // Exercício c)
                try {
                    aSocket.receive(reply);
                    long end = System.currentTimeMillis(); //Exercicio e)
                    System.out.println("<Client> Recebeu: " + new String(reply.getData()));
                    System.out.println("Demorou -> " + (end - start)); // Exercício e)
                } catch (SocketTimeoutException e) {
                    System.out.println("<Client> Timeout: " + e.getMessage());
                }
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null)
                aSocket.close();
        }
    }
}
/*
 * 4 - a) O server continua à escuta. b) O cliente envia mas não há feedback de mensagem recebida
 * pelo server. c)
 * 
 * 
 * 
 */
