import java.net.*;
import java.io.*;

public class Server2 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2222);
            System.out.println("Server started on port " + 2222);

            while (true) {
                Socket sSocket = serverSocket.accept();
                System.out.println("Client connected");
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
                char clientType = ' ';

                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client: " + inputLine);
                    if (inputLine.equalsIgnoreCase("end")) {
                        break;
                    }

                    if (inputLine.length() == 1 && (inputLine.charAt(0) == 'A' || inputLine.charAt(0) == 'B')) {
                        clientType = inputLine.charAt(0);
                        out.println(" Client type has been set to " + clientType + ".");
                    } else {
                        if (clientType == 'A') {
                            out.println(inputLine + "^2 = " + Math.pow(Integer.parseInt(inputLine), 2));
                        } else if (clientType == 'B') {
                            out.println(" sqrt(" + inputLine + ") = " + Math.sqrt(Double.parseDouble(inputLine)));
                        }
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