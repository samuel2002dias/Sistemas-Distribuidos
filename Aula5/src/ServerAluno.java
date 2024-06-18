import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class ServerAluno {
	// Lista de alunos
	private ArrayList<Aluno> listaAlunos = readAlunosFromFile();

	// 5 conexões
	private ConnectionAluno c1;
	private ConnectionAluno c2;
	private ConnectionAluno c3;
	private ConnectionAluno c4;
	private ConnectionAluno c5;

	// Array para seguir o nr de acessos
	private int[] numeroAcessos;

	public ServerAluno() {
<<<<<<< Updated upstream
		
		int portNumber = 2222;
=======

		// Create a server socket to listen for client connections
>>>>>>> Stashed changes
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(2222);
			System.out.println("Server started");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

		// Inicializar com o número de acessos a 0
		numeroAcessos = new int[1];
		numeroAcessos[0] = 0;

		// Aceita 5 conexões em simultaneo, acima disso dá erro
		c1 = new ConnectionAluno(serverSocket, numeroAcessos, listaAlunos);
		c2 = new ConnectionAluno(serverSocket, numeroAcessos, listaAlunos);
		c3 = new ConnectionAluno(serverSocket, numeroAcessos, listaAlunos);
		c4 = new ConnectionAluno(serverSocket, numeroAcessos, listaAlunos);
		c5 = new ConnectionAluno(serverSocket, numeroAcessos, listaAlunos);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// Cria instancia do servidor
		ServerAluno s = new ServerAluno();
	}

	// Le de um ficheiro aluno.txt
	private static ArrayList<Aluno> readAlunosFromFile() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"C:\\Users\\BEIRATOOLS\\Desktop\\Sistemas-Distribuidos\\Aula5\\src\\aluno.txt"))) {
			alunos = (ArrayList<Aluno>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error reading lines of text: " + e.getMessage());
		}
		return alunos;
	}
}