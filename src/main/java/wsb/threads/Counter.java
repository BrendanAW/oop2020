package wsb.threads;

import java.util.concurrent.TimeUnit;

public class Counter implements Runnable {
    private final Finisher finisher;

    public Counter(Finisher finisher) {
        this.finisher = finisher;
    }

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

        finisher.finishHim();
    }

    public static void main(String[] args) {
        //Task 9A
//        new Thread(new Counter()).start();
//        new Thread(new Counter()).start();

        //Task 9b
//        new Thread(new Scorpion()).start();
//        new Thread(new SubZero()).start();

        new Thread(new Counter(() -> System.out.println("Get over here!"))).start();
        new Thread(new Counter(() -> System.out.println("Give me your heart!!"))).start();


    }
}
