import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ex7 {

	public static void main(String[] args) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//ex6.txt"))) {
            @SuppressWarnings("unchecked")
            ArrayList<String> lines = (ArrayList<String>) ois.readObject();
            System.out.println("Lines of text read from file:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading lines of text: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error reading lines of text: " + e.getMessage());
        }
	}

}