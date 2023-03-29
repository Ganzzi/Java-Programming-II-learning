package D5_threads;

/**
 *
 * @author Admin
 */
public class EX03_runnableThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("i: " + i);
        }
    }

}
