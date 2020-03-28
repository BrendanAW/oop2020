package wsb;

import wsb.devices.Car;
import wsb.devices.Device;
import wsb.devices.Phone;

public class Main {

    public static void main(String[] args) throws Exception {

        Animal dog = new Animal("dog");
        dog.name = "Akita";

        Phone iphone = new Phone("Apple", "6s", 4.7);

        Human me = new Human();
        me.firstName = "Kacper";
        me.lastName = "Warda";
        me.pet = dog;
        me.mobile = iphone;

        me.pet.feed();
        me.pet.takeForAWalk();
        me.pet.feed();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();
        me.pet.takeForAWalk();

        Car dirtyOne = new Car("fiat", "bravo", 2014, 1.6);
        dirtyOne.plates = "GDA2314";
        me.car = dirtyOne;
        System.out.println(me.car.producer + " " + me.car.model + " " + me.car.plates);

        System.out.println(me instanceof Animal);
        System.out.println(me instanceof Human);
        System.out.println(me instanceof Object);

        me.feed();
        me.pet.feed();

        iphone.turnOn();
        dirtyOne.turnOn();


        Human myWife = new Human();
        myWife.firstName = "Karolina";
        myWife.lastName = "Warda";
        myWife.car = dirtyOne;


        System.out.println(me.car);
        System.out.println(me);

        Human brotherInLaw = new Human();
        brotherInLaw.firstName = "Mateusz";
        brotherInLaw.lastName = "Skiba";

        me.car.sell(brotherInLaw, me, 100.0);
        System.out.println("Now I have " + me.cash + "$");
        System.out.println("Now he has " + brotherInLaw.cash + "$");
        System.out.println("My car is now: " + me.car);
        System.out.println("His car is now: " + brotherInLaw.car);


    }
}
