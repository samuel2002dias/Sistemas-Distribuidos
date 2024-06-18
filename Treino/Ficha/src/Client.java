import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private Socket s = null;
    private ArrayList<String> livros;

    public Client() {
        try {
            s = new Socket("localhost", 2222);
            System.out.println("Conectado ao servidor\n");
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            livros = new ArrayList<String>();
            while (true) {
                System.out.println("1 - Oferecer um livro\n2 - Levantar um livro\n3 - Consultar Livros\n4 - Sair");
                String opcao = (String) in.readObject();
                out.writeObject(opcao);
                out.flush();
                switch (opcao) {
                    case "1":
                        System.out.println("Nome do livro: ");
                        String nome = (String) in.readObject();
                        out.writeObject(nome);
                        break;
                    case "2":
                        System.out.println("Nome do livro: ");
                        String nome2 = (String) in.readObject();
                        out.writeObject(nome2);
                        break;

                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao servidor via cliente");
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
