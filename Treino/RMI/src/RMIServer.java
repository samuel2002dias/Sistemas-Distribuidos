import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIServer {
    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(2222);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar registro RMI");
        }
        try {
            RMIInterface objeto_remoto = new RMIImpl();
            Naming.rebind("//localhost:2222/RMIImpl", objeto_remoto);
            System.out.println("Objeto remoto registrado no registry");
        } catch (MalformedURLException | RemoteException e) {
            System.err.println("Erro no registo do objeto remoto");
        }
    }

}