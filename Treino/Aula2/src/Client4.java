import java.io.*;
import java.net.*;

public class Client4 {
    public static void main(String[] args) {
        String serverAdress = "127.0.0.1";
        try {
            Socket serverSocket = new Socket(serverAdress, 2222);
            ObjectOutputStream output = new ObjectOutputStream(serverSocket.getOutputStream());
            output.flush();
            ObjectInputStream input = new ObjectInputStream(serverSocket.getInputStream());

            String message;
            do {
                System.out.println("O cliente diz:");
                BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
                message = keyboardIn.readLine();
                output.writeObject(message);
                output.flush();

                message = (String) input.readObject();
                System.out.println("Server: " + message);
            } while (!message.equalsIgnoreCase("exit"));

            input.close();
            output.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
}
