public interface RMIAlunoInterface extends java.rmi.Remote {
   public String registaAluno(String nome, String numero, String curso, String telemovel, String email)
            throws java.rmi.RemoteException;

    public String output() throws java.rmi.RemoteException;

    public String devolveNumContacto(String nomeAluno) throws java.rmi.RemoteException;

    public int getServerCount() throws java.rmi.RemoteException;

}
