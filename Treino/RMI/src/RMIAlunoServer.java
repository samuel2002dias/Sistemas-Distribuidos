import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RMIAlunoServer {
    public static void main(String[] argv) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(2222);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar registro RMI");
        }
        try {
            RMIAlunoInterface objeto_remoto = new RMIAlunoImpl();
            Naming.rebind("//localhost:2222/RMIImpl", objeto_remoto);
            System.out.println("Registrando objeto remoto no registry");
        } catch (MalformedURLException | RemoteException e) {
            System.err.println("Erro no registo do objeto remoto");
        }
    }
}