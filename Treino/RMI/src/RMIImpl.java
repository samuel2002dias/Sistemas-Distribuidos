import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class RMIImpl extends UnicastRemoteObject implements RMIInterface 
{
    public RMIImpl() throws java.rmi.RemoteException {
        super();
    }

    public int soma(int a, int b) throws java.rmi.RemoteException {
        return a + b;
    }

    public int subtracao(int a, int b) throws java.rmi.RemoteException {
        return a - b;
    }
    
    public int multiplicacao(int a, int b) throws java.rmi.RemoteException {
        return a * b;
    }

    public int divisao(int a, int b) throws java.rmi.RemoteException {
        return a / b;
    }
}
