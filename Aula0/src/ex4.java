

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex4 {

	public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//teste2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

}