public interface RMIInterface extends java.rmi.Remote {
    public int ofereceLivro(String livro) throws java.rmi.RemoteException;

    public void removerLivro(String livro) throws java.rmi.RemoteException;

    public java.util.ArrayList<String> listalivros() throws java.rmi.RemoteException;

}