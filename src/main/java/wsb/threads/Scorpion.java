package wsb.threads;

public class Scorpion extends Counter{
    @Override
    public void run() {
        super.run();
        finishHim();
    }

    private void finishHim(){
        System.out.println("Get over here punk!!");
    }
}
