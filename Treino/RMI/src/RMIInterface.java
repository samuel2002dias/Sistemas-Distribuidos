public interface RMIInterface extends java.rmi.Remote {
    public int soma(int a, int b) throws java.rmi.RemoteException;

    public int subtracao(int a, int b) throws java.rmi.RemoteException;

    public int multiplicacao(int a, int b) throws java.rmi.RemoteException;

    public int divisao(int a, int b) throws java.rmi.RemoteException;

}
