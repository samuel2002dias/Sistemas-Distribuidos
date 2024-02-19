import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//ex6.txt"))) {

			ArrayList<String> lines = new ArrayList<String>();
			while (true) {
				System.out.print("Enter a line of text (or 'done' to finish): ");
				String line = scanner.nextLine();
				if (line.equals("done")) {
					break;
				}
				lines.add(line);
			}
			oos.writeObject(lines);
			System.out.println("Lines of text written to file.");
		} catch (IOException e) {
			System.err.println("Error writing lines of text: " + e.getMessage());
		}
	}

} 
