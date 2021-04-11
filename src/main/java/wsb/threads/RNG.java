package wsb.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class RNG implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
        return new Random().nextDouble();
    }

    public static void main(String[] args) throws Exception {
        //Task 9E
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<Double> value = executorService.submit(new RNG());
//        System.out.println("Man we're not doing anything");
//        System.out.println("Will it print before this?");
//        System.out.println("Will it print before this?");
//        System.out.println("Will it print before this?");
//        System.out.println("Will it print before this?");
//        System.out.println("Will it print before this?");
//        System.out.println("Will it print before this?");
//        System.out.println("Will it print before this?");
//        System.out.println("Will it print before this?");
//        System.out.println(value.get());
        List<Finisher> finishers = List.of(
                () -> System.out.println("Scorpion rips out your heart!!"),
                () -> System.out.println("SubZero freezes your brain!!"),
                () -> System.out.println("Katana katanas your face!!"),
                () -> System.out.println("Goro rips off all four of your limbs at once!!"),
                () -> System.out.println("Idk man I ran out of my knowledge of MK guys!!")

        );

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Double> value = executor.submit(new RNG());
        int winner = (int) (value.get() * 5);
        finishers.get(winner).finishHim();
    }
}
