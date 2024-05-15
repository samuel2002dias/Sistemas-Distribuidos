import java.rmi.RemoteException;

@SuppressWarnings("unused")
public class CidadeFactoryImpl extends java.rmi.server.UnicastRemoteObject
        implements CidadeFactory {

    public CidadeFactoryImpl() throws java.rmi.RemoteException {
        super();
    }

    public Cidade getServidorCidade(String nomeCidade)
            throws java.rmi.RemoteException {
        CidadeImpl ServidorCidade = new CidadeImpl(nomeCidade);
        return (Cidade) ServidorCidade;
    }

    public static void main(String arg[]) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            CidadeFactory factory = new CidadeFactoryImpl();
            java.rmi.Naming.rebind("CidadeFactory", factory);
            System.out.println("CidadeFactory registada");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}