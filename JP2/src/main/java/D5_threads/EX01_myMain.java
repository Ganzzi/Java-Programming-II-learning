package D5_threads;

import java.util.concurrent.atomic.AtomicInteger;

public class EX01_myMain {

    public static void main(String[] args) {
        EX02_myThread t1 = new EX02_myThread();
        t1.setName("t1");
        t1.start();

        EX02_myThread t2 = new EX02_myThread();
        t2.setName("t2");
        t2.start();

        EX03_runnableThread r3 = new EX03_runnableThread();
        Thread tr3 = new Thread(r3);
        tr3.start();

        int n = 10;
        AtomicInteger ai = new AtomicInteger(n); // create a virtual variable
        Runnable n2 = new Runnable() {
            @Override
            public void run() {
                ai.set(15);
            }
        };
        Thread tn2 = new Thread(n2);
        tn2.start();

        System.out.println("Done appear when threads is running!");

        try {
            // join() y/c main thread wait t1 t2 thread to end
            t1.join();
            t2.join();
            tr3.join();
            tn2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ai = " + ai.get() + "n = " + n);
        System.out.println("Done!");

    }
}
