

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ex5b {

	public static void main(String[] args) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//persons.txt"))) {
            while (true) {
            	try {
                    Person person = (Person) ois.readObject();
                    System.out.println(person);
                } catch (EOFException e) {
                    System.out.println("Fim do ficheiro!");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro de leitura: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: " + e.getMessage());
        }
	}

}