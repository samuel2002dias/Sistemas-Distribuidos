import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIAlunoImpl extends UnicastRemoteObject implements RMIAlunoInterface {
    ArrayList<Aluno> listaAlunos;
    int serverCount = 0;

    public RMIAlunoImpl() throws java.rmi.RemoteException {
        super();
        listaAlunos = new ArrayList<Aluno>();
    }

    public String registaAluno(String nome, String numero, String curso, String telemovel, String email) {
        synchronized (listaAlunos) {
            Boolean alunosRepetidos = verificaRepetidos(Integer.parseInt(numero), listaAlunos);

            if (alunosRepetidos) {
                return ("Aluno repetido.");
            } else {
                Aluno novo = new Aluno(Integer.parseInt(numero), nome, curso, Integer.parseInt(telemovel), email);
                listaAlunos.add(novo);
                writeAlunosToFile(listaAlunos);
                return ("Registado com sucesso.");
            }
        }
    }

    public Boolean verificaRepetidos(int numAluno, ArrayList<Aluno> alunos) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getNumero() == numAluno)
                return true;
        }
        return false;
    }

    public String output() {
        String output = "";
        System.out.println("ALUNOS REGISTADOS \n");
        for (Aluno aluno : listaAlunos) {
            output += aluno.getNumero() + " " + aluno.getNome() + " " + aluno.getCurso() + " " + aluno.getTelemovel()
                    + " " + aluno.getEmail() + "\n";
        }
        return output;
    }

    public String devolveNumContacto(String nome) {
        String lista = "";
        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equals(nome)) {
                lista += aluno.getNome() + "\n";
                lista += aluno.getTelemovel();
            }
            lista += "\n";

        }

        return lista;
    }

    public int getServerAccessCount() {
        serverCount++;
        return serverCount;
    }

    public void writeAlunosToFile(ArrayList<Aluno> alunos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                "C:\\Users\\Admin\\Desktop\\Sistemas-Distribuidos\\Treino\\RMI\\src\\alunos.txt"))) {
            oos.writeObject(alunos);
        } catch (IOException e) {
            System.err.println("Error writing list of students: " + e.getMessage());
        }
    }
    
      public ArrayList<Aluno> readAlunosFromFile() {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "C:\\\\Users\\\\Admin\\\\Desktop\\\\Sistemas-Distribuidos\\\\Treino\\\\RMI\\\\src\\\\alunos.txt"))) {
            alunos = (ArrayList<Aluno>) ois.readObject();
        } catch (

        IOException e) {
            System.err.println("Error reading lines of text: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error reading lines of text: " + e.getMessage());
        }
        return alunos;
    }

    @Override
    public int getServerCount() throws RemoteException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getServerCount'");
    }

}
