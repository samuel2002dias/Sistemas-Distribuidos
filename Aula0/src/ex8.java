import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ex8 {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//livros.txt"))) {
				// Alterar o caminho do ficheiro para o caminho do ficheiro caso necessário

			ArrayList<String> books = new ArrayList<String>();
			while (true) {
				System.out.print("Digite o nome do livro (ou 'done' para fechar a execução): ");
				String book = scanner.nextLine();
				if (book.equals("done")) {
					break;
				}
				books.add(book);
			}
			oos.writeObject(books);
			System.out.println("Lista de livros escrita no ficheiro");
		} catch (IOException e) {
			System.err.println("Erro ao escrever no ficheiro: " + e.getMessage());
		}
	}

}