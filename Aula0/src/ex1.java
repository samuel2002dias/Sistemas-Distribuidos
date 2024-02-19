
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ex1 {
	public static void main (String args[]){
		 BufferedWriter bw;
		 try {
		 bw = new BufferedWriter ( new FileWriter ("C://Users//Admin//Desktop//Sistemas-Distribuidos//Aula0//teste1.txt"));
		 bw.write("1");
		 bw.newLine();
		 bw.write("2");
		 bw.flush();
		 bw.close();
	 }
	 catch (IOException e){
		 System.out.println(e.getMessage());
	 }
	}
}