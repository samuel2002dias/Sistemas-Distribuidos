
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionAluno extends Thread {
    private ServerSocket serverSocket;
    Socket clientSocket = null;
    private int[] numeroAcessos;
    private ArrayList<Aluno> listaAlunos;

    private static final String SERVER_HEADER = "\n_______________________\n|        SERVER       |\n\n";

    public ConnectionAluno(ServerSocket serverSocket, int[] numeroAcessos, ArrayList<Aluno> listaAlunos) {
        super();
        this.serverSocket = serverSocket;
        this.numeroAcessos = numeroAcessos;
        this.listaAlunos = listaAlunos;
        start();
    }

    public void run() {
        try {
            while (true) {
                // Increment the number of accesses to the server
                synchronized (numeroAcessos) {
                    // Wait for a client to connect
                    clientSocket = serverSocket.accept(); // Its placed here because it is not thread safe
                    numeroAcessos[0]++;
                }

                // Print client information
                System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " connected");

                // Setup input and output streams
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.flush();
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

                // Send welcome message to the client
                out.writeObject("Connected to the server " + serverSocket.getInetAddress().getHostAddress());

                String inputLine = (String) in.readObject();
                // out.writeObject(inputLine);

                // Read input from the client
                boolean continueLoop = true;

                while (continueLoop) {

                    switch (inputLine) {
                        case "1":
                            // Register a new student
                            synchronized (listaAlunos) {
                                String numero = (String) in.readObject();
                                String nome = (String) in.readObject();
                                String curso = (String) in.readObject();
                                String telemovel = (String) in.readObject();
                                String email = (String) in.readObject();

                                // Check if the student is already registered
                                boolean isDuplicate = verificaRepetidos(Integer.parseInt(numero), listaAlunos);

                                if (isDuplicate) {
                                    out.writeObject(SERVER_HEADER
                                            + "Aluno repetido. Não foi registado novamente. Número de alunos registados: "
                                            + listaAlunos.size() + ".\n\n");
                                    out.flush();
                                } else {
                                    Aluno novo = new Aluno(Integer.parseInt(numero), nome, curso,
                                            Integer.parseInt(telemovel), email);
                                    listaAlunos.add(novo);
                                    writeAlunosToFile(listaAlunos);
                                    out.writeObject(
                                            SERVER_HEADER + "Registado com sucesso. Número de alunos registados: "
                                                    + listaAlunos.size() + ".\n\n");
                                    out.flush();
                                }
                            }
                            break;
                        case "2":
                            // Send the list of registered students to the client
                            out.writeObject(outputListaDeAlunos(listaAlunos));
                            out.flush();
                            break;
                        case "3":
                            // Send the number of accesses to the server to the client
                            out.writeObject(SERVER_HEADER + "Numero de acessos ao servidor ate ao momento: "
                                    + numeroAcessos[0] + "\n\n");
                            out.flush();
                            break;
                        case "4":
                            // Send the phone number of a specific student to the client
                            String nome = (String) in.readObject();
                            out.writeObject(devolveNumContacto(nome, listaAlunos));
                            out.flush();
                            break;
                        case "5":
                            // Close the connection
                            System.out.println(
                                    "Client " + clientSocket.getInetAddress().getHostAddress() + " disconnected");

                            synchronized (numeroAcessos) {
                                numeroAcessos[0] = numeroAcessos[0] - 1;
                            }
                            continueLoop = false;
                            break;
                    }
                }

            }

        } catch (IOException | ClassNotFoundException e) {
        }
        try {

            clientSocket.close();

            System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " disconnected");

            synchronized (numeroAcessos) {
                numeroAcessos[0] = numeroAcessos[0] - 1;
            }
        } catch (IOException e) {
        }
    }

    private static Boolean verificaRepetidos(int numAluno, ArrayList<Aluno> alunos) {
        for (Aluno aluno : alunos) {
            if (aluno.getNumero() == numAluno)
                return true;
        }
        return false;
    }

    private static String outputListaDeAlunos(ArrayList<Aluno> alunos) {
        String lista = SERVER_HEADER + "-----------------------\n";
        lista += "         ALUNOS        \n";
        lista += "-----------------------\n";
        for (Aluno aluno : alunos) {
            lista += "Número: " + aluno.getNumero() + "\n";
            lista += "Nome: " + aluno.getNome() + "\n";
            lista += "Curso: " + aluno.getCurso() + "\n";
            lista += "Telemóvel: " + aluno.getTelemovel() + "\n";
            lista += "Email: " + aluno.getEmail() + "\n";
            lista += "-----------------------\n";
        }
        lista += "\n";
        return lista;
    }

    private static String devolveNumContacto(String nome, ArrayList<Aluno> alunos) {
        String lista = SERVER_HEADER;
        lista += "-----------------------\n";
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                lista += "Número: " + aluno.getNumero() + "\n";
                lista += "Telemóvel: " + aluno.getTelemovel() + "\n";
                lista += "-----------------------\n\n";
            }
        }

        return lista;
    }

    private static void writeAlunosToFile(ArrayList<Aluno> alunos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\joaop\\Desktop\\SD\\ficha5\\src\\aluno.ser"))) {
            oos.writeObject(alunos);
        } catch (IOException e) {
            System.err.println("Error writing list of students: " + e.getMessage());
        }
    }
}