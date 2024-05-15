import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket s;

    public Client() {
        String serverAddress = "127.0.0.1";

        try {
            s = new Socket(serverAddress, 2222);
            System.out.println("Connected to server");
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            int option = 0;
            while (true) {
                System.out.println("1 - OPÇÃO 1");
                System.out.println("2 - OPÇÃO 2");
                System.out.println("3 - QUIT");
                System.out.print("Your choice: ");
                option = Ler.umInt();
                out.writeObject(option);
                out.flush();
                System.out.println(in.readObject());
            }
            //s.close();
        } catch (IOException e) {
            System.err.println("Erro Client");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro Server Class not found");
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
