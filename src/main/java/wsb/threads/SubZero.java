package wsb.threads;

public class SubZero extends Counter {
    @Override
    public void run() {
        super.run();
        finishHim();
    }

    private void finishHim() {
        System.out.println("Rip his frozen heart out!!!");
    }
}
