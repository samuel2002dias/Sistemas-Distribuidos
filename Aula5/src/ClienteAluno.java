
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteAluno {
	public static void main(String[] args) {
		// Set server IP and port number
		String serverAddress = "127.0.0.1";
		int portNumber = 2222;

		try {
			// Connect to server
			Socket socket = new Socket(serverAddress, portNumber);

			// Initialize input and output streams

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			// Read welcome message from server
			String inputLine = "";
			try {
				inputLine = (String) in.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("erro");
				e.printStackTrace();
			}
			

			// If server is full, close the connection
			if (inputLine.equals("Server reached maximum capacity, try again later.")) {
				System.out.println("Closing connection...");
				socket.close();
			} else {
				// Loop until user quits
				while (true) {
					System.out.println();
					System.out.println("1. Register student");
					System.out.println("2. Consult students");
					System.out.println("3. Consult accesses");
					System.out.println("4. View student data");
					System.out.println("5. Quit");
					System.out.print("Enter your choice (1-4): ");

					// Read user input
					String choice = new BufferedReader(new InputStreamReader(System.in)).readLine();

					// Send user choice to server
					out.writeObject(choice);
					out.flush();

					// Process user choice
					switch (choice) {
						case "1":
							// Register student
							System.out.print("\nNumber: ");
							String number = new BufferedReader(new InputStreamReader(System.in)).readLine();
							out.writeObject(number);

							System.out.print("Name: ");
							String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
							out.writeObject(name);

							System.out.print("Course: ");
							String course = new BufferedReader(new InputStreamReader(System.in)).readLine();
							out.writeObject(course);

							System.out.print("Phone number: ");
							String phone = new BufferedReader(new InputStreamReader(System.in)).readLine();
							out.writeObject(phone);

							System.out.print("Email: ");
							String email = new BufferedReader(new InputStreamReader(System.in)).readLine();
							out.writeObject(email);
							break;

						case "4":
							// View student data
							System.out.print("\nName: ");
							String studentName = new BufferedReader(new InputStreamReader(System.in)).readLine();
							out.writeObject(studentName);
							break;

						case "5":
							// Quit
							System.out.println("Closing connection...");
							socket.close();
							return;
					}

					// Read server response
					try {
						while ((inputLine = (String) in.readObject()) != null) {
							if (inputLine.equals("EOF")) {
								break;
							}
							System.out.println(inputLine);
						}
					} catch (ClassNotFoundException e) {
						System.err.println("ERRO");
						e.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}