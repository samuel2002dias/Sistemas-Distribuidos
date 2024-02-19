

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ex5a {

	public static void main(String[] args) {
		Person p1 = new Person ("Samuel", 21, "samueldias2002@gmail.com", "999999999");
		Person p2 = new Person ("Joao", 20, "joao@gmail.com", "92000000");
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//persons.txt"))) {
            oos.writeObject(p1);
            oos.writeObject(p2);
            System.out.println("Persons objects written to file.");
        } catch (IOException e) {
            System.err.println("Error writing Person object: " + e.getMessage());
        }
	}

}