import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ServerSocket serverSocket;
    private Socket sServidor = null;
    private int conexoes;
    private Connection c;
    private ArrayList<String> livros;

    public Server() {
        try {
            serverSocket = new ServerSocket(2222);
            System.out.println("Conexão estabelecida na porta 2222");
        } catch (Exception e) {
            System.err.println("Erro criar server");
        }
        try {
            while (true) {
                sServidor = serverSocket.accept();
                conexoes++;
                c = new Connection(sServidor, conexoes);
            }
        } catch (Exception e) {
            System.err.println("Erro ao aceitar conexão");
        }
    }
    
    public static void main(String[] args) {
        Server s = new Server();
    }
}


