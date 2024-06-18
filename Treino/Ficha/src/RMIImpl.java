import java.rmi.RemoteException;
import java.util.ArrayList;

public class RMIImpl extends java.rmi.server.UnicastRemoteObject implements RMIInterface {
    ArrayList<String> livros;

    public RMIImpl() throws java.rmi.RemoteException {
        super();
        this.livros = new ArrayList<String>();
    }

    public int ofereceLivro(String livro) throws RemoteException {
        livros.add(livro);
        return livros.size();
    }

    public void removerLivro(String livro) throws RemoteException {
        livros.remove(livro);

    }

    public ArrayList<String> listalivros() throws RemoteException {
        return livros;

    }

  
}
