
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;  

public class ex3 {

	public static void main(String[] args) {
		try {
			PrintWriter pw = new PrintWriter ( new FileWriter ("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//teste2.txt"));
			pw.println(2.31);
			pw.println(false);
			pw.print("X");
			pw.flush();
			pw.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}

}