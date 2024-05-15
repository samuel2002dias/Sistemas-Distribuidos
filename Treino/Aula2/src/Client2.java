import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        try {
            String inputline;
            Socket socket = new Socket(serverAddress, 2222);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connected!");

            while (true) {
                System.out.println("Escreve mensagem:");
                String outputLine = keyboardIn.readLine();
                if (outputLine.equalsIgnoreCase("end")) {
                    System.out.println("Closing...");
                    socket.close();
                    break;
                }
                out.println(outputLine);
                out.flush();

                inputline = in.readLine();
                System.out.println("Server:" + inputline);
            }
        } catch (Exception e) {
            System.err.println("Erro");
        }

    }
}
