import java.net.*;
import java.io.*;

public class Server5 {
    static int numeroAcessos = 0;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2222);
            System.out.println("Server started on port " + 2222);

            while (true) {
                Socket sSocket = serverSocket.accept();
                System.out.println("Client connected");
                numeroAcessos++;
                new ClientHandler(sSocket).start();
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket sSocket;

        public ClientHandler(Socket socket) {
            this.sSocket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(sSocket.getInputStream()));
                PrintWriter out = new PrintWriter(sSocket.getOutputStream(), true);

                String inputLine;
                
               

                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client: " + inputLine);
                    if (inputLine.equalsIgnoreCase("end")) {
                        break;
                    }
                }

                System.out.println("Client " + sSocket.getInetAddress().getHostAddress() + " disconnected");
                sSocket.close();
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            }
        }
    }
}