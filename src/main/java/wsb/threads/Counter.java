package wsb.threads;

import java.util.concurrent.TimeUnit;

public class Counter implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //Task 9A
//        new Thread(new Counter()).start();
//        new Thread(new Counter()).start();

        //Task 9b
        new Thread(new Scorpion()).start();
        new Thread(new SubZero()).start();
    }
}
