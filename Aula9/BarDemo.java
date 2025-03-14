import java.util.concurrent.*;

class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
        System.out.println("Starting");
        new Thread(new MyThread(cb, "A")).start();
        new Thread(new MyThread(cb, "B")).start();
        new Thread(new MyThread(cb, "C")).start();
    }
}

class MyThread implements Runnable {
    CyclicBarrier cbar;
    String name;
    MyThread(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
    }
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        } catch (BrokenBarrierException | InterruptedException exc) {
            System.out.println(exc);
        }
    }
}

class BarAction implements Runnable {
    public void run() {
        System.out.println("Barrier Reached!");
    }
}