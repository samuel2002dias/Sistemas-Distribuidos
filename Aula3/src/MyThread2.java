public class MyThread2 extends Thread {
    public MyThread2() {
        super();
        start();
    }

    public void run() {
        System.out.println("Hello there, from " + Thread.currentThread().getName());

    }
}