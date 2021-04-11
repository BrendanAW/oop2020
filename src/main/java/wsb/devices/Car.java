package wsb.devices;

import wsb.creatures.Human;
import wsb.Soldable;

import java.util.Comparator;

public abstract class Car extends Device implements Soldable, Comparable<Car> {
    public final Integer yearOfProduction;
    public final Engine engine;
    public String plates;
    public boolean isRunning = false;

    public Car(String producer, String model, Integer yearOfProduction, Double sizeOfAnEngine, Integer horsePower, Double mileage) {
        super(producer, model);
        this.yearOfProduction = yearOfProduction;
        engine = new Engine(horsePower, mileage, sizeOfAnEngine);
    }

    public Car(String producer, String model, Integer yearOfProduction) {
        super(producer, model);
        this.yearOfProduction = yearOfProduction;
        engine = new Engine();
    }

    abstract public void refuel();

    @Override
    public void turnOn() {
        isRunning = true;
        engine.turnOn();
    }

    public void stopCar() {
        isRunning = false;
    }

    @Override
    public String toString() {
        return this.producer + " " + this.model;
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.yearOfProduction - otherCar.yearOfProduction;
    }

    @Override
    public void sell(Human buyer, Human seller, Double price) throws Exception {
        if (!seller.hasACar(this)) {
            throw new Exception("seller don't have a car");
        }
        if (!buyer.hasAFreePlace()) {
            throw new Exception("bouer dont have a plase");
        }
        if (buyer.cash < price) {
            throw new Exception("afwfwaawfawf");
        }
        buyer.removeCar(this);
        seller.addCar(this);
        buyer.cash -= price;
        seller.cash += price;
        System.out.println("great, transaction is done");
    }

    private static class Engine {
        int horsePower;
        double mileage;
        double volume;
        final String turnOnMessage;

        Engine(int horsePower, double mileage, double volume) {
            this.horsePower = horsePower;
            this.mileage = mileage;
            this.volume = volume;
            this.turnOnMessage = "car is ready to go";
        }

        Engine() {
            this.turnOnMessage = "Shhh electric car go brr";
        }

        void turnOn() {
            System.out.println(turnOnMessage);
        }

    }
}