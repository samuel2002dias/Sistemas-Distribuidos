public class testeReentrant extends Thread {
    Reentrant R;

    public testeReentrant() {
        R = new Reentrant();
        Thread T = new Thread(this);
        T.start();
    }

    public void run() {
        R.myMethod();
    }

    @SuppressWarnings("unused")
    public static void main(String args[]) {
        testeReentrant T1 = new testeReentrant();
    }
}