import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2222);
            System.out.println("Server started on port " + 2222);

            while (true) {
                Socket sSocket = serverSocket.accept();
                System.out.println("Client connected");
                ObjectOutputStream output = new ObjectOutputStream(sSocket.getOutputStream());
                output.flush();
                ObjectInputStream input = new ObjectInputStream(sSocket.getInputStream());

                String message;
                do {
                    message = (String) input.readObject();
                } while (!message.equalsIgnoreCase("exit"));

                input.close();
                output.close();
                sSocket.close();
                System.out.println("Client disconnected");
            } 
            
            
        } catch (Exception e) {
            System.err.println("ERRO");
        }
    }
}
