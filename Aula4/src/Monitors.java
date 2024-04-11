

public class Monitors extends Thread{
	CriticaUm C1;
	public Monitors(String nomeObjecto) {
		Thread Thread_a, Thread_b;
		C1 = new CriticaUm();
	
		Thread_a = new Thread (this, nomeObjecto + ":Thread a");
		Thread_b = new Thread (this, nomeObjecto + ":Thread b");
		Thread_a.start();
		Thread_b.start();
	}
	@SuppressWarnings("static-access")
	public void run (){
		C1.method_A();
		C1.method_B();
	}
}
