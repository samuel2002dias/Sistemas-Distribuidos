import java.net.*;
import java.io.*;
import java.lang.Math;

public class Server3 {
    public static void main(String[] args) throws IOException {
        int portNumber = 2222;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " connected");
                new ClientHandler(clientSocket).start();
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }
    }

    public void run() {
        /* Completar */
    }
}
