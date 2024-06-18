import java.rmi.Naming;
import java.util.Scanner;

public class RMIClient {

    public static void main(String[] args) {
        try {
            RMIInterface server_object = (RMIInterface) Naming.lookup("//localhost:2222/RMIImpl");
            System.out.println("RMI connection successful");
            while (true) {
                System.out.println();
                System.out.println("1. Somar");
                System.out.println("2. Subtrair");
                System.out.println("3. Dividir");
                System.out.println("4. Multiplicar");
                System.out.println("5. Quit");
                System.out.print("Enter your choice (1-5): ");

                int escolha = Ler.umInt();

                System.out.println("1º número: ");
                int a = Ler.umInt();
                System.out.println("2º número: ");
                int b = Ler.umInt();

                switch (escolha) {
                    case 1:
                        System.out.println("O resultado é " + server_object.soma(a, b));
                        break;
                    case 2:
                        System.out.println("O resultado é " + server_object.subtracao(a, b));
                        break;
                    case 3:
                        System.out.println("O resultado é " + server_object.divisao(a, b));
                        break;
                    case 4:
                        System.out.println("O resultado é " + server_object.multiplicacao(a, b));
                        break;
                    case 5:
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Erro no cliente RMI.");
            System.exit(0);
        }
    }

}
