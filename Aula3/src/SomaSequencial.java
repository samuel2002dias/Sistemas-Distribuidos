public class SomaSequencial {
    public static void main(String[] args) {
        int dim = 100000000;
        int[] A = new int[dim];
        int[] B = new int[dim];
        int[] C = new int[dim];

        for (int i = 0; i < dim; i++) {
            A[i] = (int) (Math.random() * 100);
            B[i] = (int) (Math.random() * 100);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < dim; i++) {
            C[i] = A[i] + B[i];
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + "ms");

    }

}

// 3-
// c) Para arrays grandes e à medida que a complexidade aumenta, a resolução
// sequencial torna-se mais lenta que a resolução por threads.S:ms vs T:ms