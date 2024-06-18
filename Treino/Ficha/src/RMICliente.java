import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMICliente {

    public static void main(String[] args) {
        ArrayList<String> livros = new ArrayList<String>();
        try {
            RMIInterface objeto = (RMIInterface) Naming.lookup("rmi://localhost:2222/RMIImpl");
            System.out.println("Conexão RMI bem sucedida");
            while (true) {
                System.out.println("1 - Oferecer um livro\n2 - Levantar um livro\n3 - Consultar Livros\n4 - Sair");
                int escolha = 0;
                escolha = Ler.umInt();
                switch (escolha) {
                    case 1:
                        System.out.println("Nome do livro: ");
                        String nome = Ler.umaString();
                        int size = objeto.ofereceLivro(nome);
                        if (size % 2 == 0) {
                            System.out.println("Parabens! Tem um bilhete para o sorteio!");
                        } else {
                            System.out.println("Obrigado pelo livro");
                        }
                        break;
                    case 2:
                        System.out.println("Nome do livro: ");
                        String nome2 = Ler.umaString();
                        objeto.removerLivro(nome2);
                        break;
                    case 3:
                        System.out.println("Lista de livros: ");
                        System.out.println(objeto.listalivros());
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro no cliente RMI.");
        }
    }

}
