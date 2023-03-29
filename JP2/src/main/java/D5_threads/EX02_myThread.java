package D5_threads;

public class EX02_myThread extends Thread {

    @Override
    public void run() {
//        for (int i = 0; i < 20; i++) {
//            System.out.println(getName() + ": " + i);
//            try {
//                Thread.sleep(1);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

//      Lock
        synchronized (System.out) {
            for (int i = 0; i < 20; i++) {
                System.out.println(getName() + ": " + i);
            }
        }
    }
}
