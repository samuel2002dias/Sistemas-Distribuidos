import java.rmi.Naming;

public class RMIServer
{

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(2222);
            System.out.println("RMI registry pronto.");

            try {
                RMIInterface objeto_remoto = new RMIImpl();
                Naming.rebind("rmi://localhost:2222/RMIImpl", objeto_remoto);
                System.out.println("Servidor RMI pronto.");
            } catch (Exception e) {
                System.err.println("Erro no registry" + e.toString());
            }
        } catch (Exception e) {
            System.err.println("Erro na conexão " + e.toString());
        }
    }
}
