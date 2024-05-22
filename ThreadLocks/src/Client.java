import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Client {
  public static void main(String[] args) {
    String server = "localhost";
    int port = 2222;
    try (Socket socket = new Socket(server, port);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {
      String menu = "Gestor de alunos\n\n1 - Registar aluno\n2 - Listar alunos\n3 - Consultar acessos\n4 - Consultar aluno\n\n0 - Sair\n\nopção: ";
      boolean saida = false;
      int option = 0;
      do {
        try {
          System.out.print(menu);
          option = Integer.parseInt(teclado.readLine());
          ArrayList<Student> alunos;
          switch (option) {
            case 0:
              oos.writeObject("0");
              saida = true;
              break;
            case 1:
              oos.writeObject("1");
              oos.writeObject(createStudent(teclado));

              break;
            case 2:
              oos.writeObject("2");
              alunos = (ArrayList<Student>) ois.readObject();
              listStudents(alunos);

              break;
            case 3:
              oos.writeObject("3");
              int connections = Integer.parseInt((String) ois.readObject());
              System.out.println(connections);

              break;
            case 4:
              oos.writeObject("4");
              String name = searchName(teclado);
              oos.writeObject(name);
              alunos = (ArrayList<Student>) ois.readObject();
              if (!alunos.isEmpty()) {
                listStudents(alunos);
              } else {
                System.out.println("Não há alunos com o nome: " + name);
              }

              break;

          }
        } catch (NumberFormatException e) {
          System.err.println("ERRO");
        }
      } while (!saida);
    } catch (EOFException e) {
      System.err.println("Disconectado do servidor");
    } catch (ConnectException e) {
      System.err.println("ERRO ao ligar ao server");
    } catch (SocketException e) {
      System.err.println("Perdeu a conexão ao servidor");
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }

  private static Student createStudent(BufferedReader teclado) throws IOException {
    System.out.println("Nome do estudante: ");
    String name = teclado.readLine();
    System.out.println("Curso do estudante: ");
    String degree = teclado.readLine();
    System.out.println("email do estudante: ");
    String email = teclado.readLine();
    return new Student(name, degree, email);
  }

  private static void listStudents(ArrayList<Student> students) {
    for (Student student : students) {
      System.out.println("------------------------");
      System.out.println("Name: " + student.getName());
      System.out.println("Degree: " + student.getDegree());
      System.out.println("Email: " + student.getEmail());
      System.out.println("------------------------");
    }
  }

  private static String searchName(BufferedReader teclado) throws IOException {
    System.out.print("Nome do estudante: ");
    return teclado.readLine();
  }
}