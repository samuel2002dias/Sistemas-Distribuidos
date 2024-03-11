public class ThreadSoma extends Thread {
    private int[] A;
    private int[] B;
    private int[] C;
    private int u;
    private int p;



public ThreadSoma(int[] A, int[] B, int[] C, int u, int p) {
    super();
    this.A = A;
    this.B = B;
    this.C = C;
    this.u = u;
    this.p = p;
    start();
}

    public void run() {
        for (int i = u; i < p; i++) {
            C[i] = A[i] + B[i];
        }
    }
}
