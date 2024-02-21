import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ex9 {

	public static void main(String[] args) {
		ArrayList<String> bookList = readBooksFromFile();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
        	System.out.println();
            System.out.println("1. Procura determinado livro");
            System.out.println("2. Lista de livros");
            System.out.println("3. Adicionar um livro à lista");
            System.out.println("4. Sair");
            System.out.print("Digite a sua escolha (1-4): ");
            String choice = scanner.nextLine();
            switch (choice) {
	            case "1":
	                System.out.print("Digite o nome do livro que procura: ");
	                String bookName = scanner.nextLine();
	                if (bookList.contains(bookName)) {
	                    System.out.println("O livro'" + bookName + "' está na lista.");
	                } else {
	                    System.out.println("O livro '" + bookName + "' não está na lista.");
	                }
	                break;
	            case "2":
	                System.out.println("Lista de livros:");
	                for (String book : bookList) {
	                    System.out.println(book);
	                }
	                break;
	            case "3":
	                System.out.print("Digite o nome do livro: ");
	                String newBookName = scanner.nextLine();
	                bookList.add(newBookName);
	                writeBookListToFile(bookList);
	                System.out.println("Livro adicionado.");
	                break;
	            case "4":
	                System.out.println("Sair...");
	                scanner.close();
	                return;
	            default:
	                System.out.println("Escolhe ente 1 e 4");
            }
        }
	}


	@SuppressWarnings("unchecked")
    private static ArrayList<String> readBooksFromFile() {	
		ArrayList<String> books = new ArrayList<String>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//livros.txt"))) {
			books = (ArrayList<String>) ois.readObject();
        } catch (IOException e) {
            System.err.println("Erro a ler o ficheiro: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Erro a ler o ficheiro: " + e.getMessage());
        }
        return books;
	}
	
	private static void writeBookListToFile(ArrayList<String> bookList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//livros.txt"))) {
            oos.writeObject(bookList);
        } catch (IOException e) {
            System.err.println("Erro a escrever no ficheiro: " + e.getMessage());
        }
    }
}