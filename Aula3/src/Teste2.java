public class Teste2 {
    public static void main(String[] str) {
        MyThread2 T = new MyThread2();
        Thread Ta, Tb;
        Ta = new Thread(T);
        Tb = new Thread(T);
        Ta.start();
        Tb.start();
    }
}

// A execução continua a não ser deterministica, apesar de agora a thread T é a mesma