import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Connection extends Thread {
    private Socket s;
    private int conexoes;
    private ArrayList<String> livros;

    public Connection(Socket s, int conexoes) {
        super();
        this.s = s;
        this.conexoes = conexoes;
        this.livros = livros; // Initialize livros here
        start();
    }

    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            while (true) {
                String escolha = "";
                System.out.println("Escolha: " + escolha);
                if (escolha.equals("4")) {
                    conexoes--;
                    System.out.println("Conexões: " + conexoes);
                    break;
                }
                switch (escolha) {
                    case "1":
                        synchronized (livros) {
                            String nome = (String) in.readObject();
                            System.out.println("Nome: " + nome); // Debug print statement
                            livros.add(nome);
                            int tamanho = livros.size();
                            if (tamanho % 10 == 0) {
                                out.writeObject("Parabens! Tem um bilhete para o sorteio!");
                                out.flush();
                            } else {
                                out.writeObject("Obrigado pelo livro");
                                out.flush();
                            }
                            out.flush();
                        }
                        break;
                    case "2":
                        synchronized (livros) {
                            String nome2 = (String) in.readObject();
                            livros.remove(nome2);
                            out.writeObject("Livro removido");
                            out.flush();
                        }
                        break;
                    case "3":
                        out.writeObject(livros);
                        out.flush();
                        if (livros == null) {
                            System.out.println("Received null list");
                        } else if (livros.isEmpty()) {
                            System.out.println("Received empty list");
                        } else {
                            for (String yay : livros) {
                                System.out.println(yay + "\n");
                            }
                        }
                        break;
                    default:
                        break;
                }

            }
        } catch (Exception e) {
            System.err.println("Erro Connections");
        }
    }
}