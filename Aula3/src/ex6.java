public class ex6 {
    public static void main(String[] args) {
        PriorityThread T1 = new PriorityThread("T1");
        PriorityThread T2 = new PriorityThread("T2");
        PriorityThread T3 = new PriorityThread("T3");

        T1.setPriority(Thread.MAX_PRIORITY);
        T2.setPriority(Thread.NORM_PRIORITY);
        T3.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Thread " + T1.getName() + " após o setPriority tem " + T1.getPriority());
        System.out.println("Thread " + T2.getName() + " após o setPriority tem " + T2.getPriority());
        System.out.println("Thread " + T3.getName() + " após o setPriority tem " + T3.getPriority());

        T1.start();
        T2.start();
        T3.start();
    }
}

class PriorityThread extends Thread {
    public PriorityThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " (" + getPriority() + "): " + i);
        }
    }

    // Como estamos a usar um sysout, não conseguimos observar a diferença de
    // prioridade. Para isso seria necessário execução de calculo intensivo, e
    // teriamos de aceder ao gestor de tarefas para podermo ver tal execução com
    // prioridades
}