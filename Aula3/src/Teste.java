public class Teste {
    @SuppressWarnings("unused")
    public static void main(String[] str) {
        MyThread Ta, Tb;
        Ta = new MyThread("A");
        Tb = new MyThread("B");
    }

}

// A execução não é deterministica pois ou começa a thread B primeiro ou a
// thread A primeiro ou começa a thread A primeiro, sem qualquer tipo de ordem.


