package wsb;

import wsb.creatures.Animal;
import wsb.creatures.Gender;
import wsb.creatures.Human;
import wsb.creatures.Pet;
import wsb.database.Connector;
import wsb.devices.*;
import wsb.food.FoodType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {
//        ResultSet rs = Connector.getStatement().executeQuery("SELECT * FROM animal");

//        List<Animal> animals = new LinkedList<>();
//
//        while (rs.next()) {
//            Animal animal = new Animal(rs.getString("species"), rs.getDouble("weight"));
//            animal.name = rs.getString("name");
//            animals.add(animal);
//        }
//
//        System.out.println(animals);
//        for (String arg : args) {
//            System.out.println(arg);
//        }

        Map<String, Car> carMap = new HashMap<>();
        carMap.put("Ferrari", new DieselCar("Ferrari", "Shiny", 2002, 5.5));
        carMap.put("Linguine", new DieselCar("Linguine", "Shoddy", 2022, 2.5));
        carMap.put("Biggs", new DieselCar("Biggs", "Shorty", 1998, 5.4));
        carMap.put("Toyota", new DieselCar("Toyota", "Shevy", 2011, 2.3));

        carMap.values().stream().map(Car::getModel).sorted().forEach(System.out::println);
    }


    //Create a HashMap with String model as key and Car as value
    //	2. Add a few cars into a map.
    //	3. Print it in alphabetical order of models.
    private static void pileOfCode() throws Exception {
        Connector.connect();

        Pet dog = new Pet("dog", FoodType.MEAT);
        dog.name = "Akita";

        Phone iphone = new Phone("Apple", "6s", 4.7, OS.IOS);

        Human me = new Human(3, Gender.MALE, FoodType.ALL);
        me.firstName = "Kacper";
        me.lastName = "Warda";
        me.pet = dog;
        me.mobile = iphone;


        Car dirtyOne = new DieselCar("fiat", "bravo", 2014, 1.6);
        dirtyOne.plates = "GDA2314";
        me.setCar(dirtyOne, 0);
        System.out.println(me.getCar(0).producer + " " + me.getCar(0).model + " " + me.getCar(0).plates);


        iphone.turnOn();
        dirtyOne.turnOn();


        Human myWife = new Human(4, Gender.FEMALE, FoodType.ALL);
        myWife.firstName = "Karolina";
        myWife.lastName = "Warda";
        myWife.setCar(new ElectricCar("Tesla", "S", 2019), 0);


        System.out.println(me.getCar(0));
        System.out.println(me);

        Human brotherInLaw = new Human(2, Gender.MALE, FoodType.ALL);
        brotherInLaw.firstName = "Mateusz";
        brotherInLaw.lastName = "Skiba";

//        me.getCar(0).sell(brotherInLaw, me, 100.0);
        System.out.println("Now I have " + me.cash + "$");
        System.out.println("Now he has " + brotherInLaw.cash + "$");
        System.out.println("My car is now: " + me.getCar(0));
        System.out.println("His car is now: " + brotherInLaw.getCar(0));


        String[] names = {"Kacper", "Jakub", "Artur"};
        for (String name : names) {
            System.out.println("my name is " + name);
        }

        names = new String[4];

        Set<Object> humans = new TreeSet<>();

        humans.add(me);
        humans.add(myWife);
        humans.add(me);
        humans.add(brotherInLaw);
        humans.add(new Animal("dog", FoodType.ALL));


        System.out.println(me.getCar(0).value);

        App facebook = new App("facebook", "latest", 0.0);
        App spotify = new App("spotify", "2.3.41", 14.0);
        App messenger = new App("messenger", "latest", 0.0);

        me.mobile.installAnApp(facebook, me);
        me.mobile.installAnApp(spotify, me);
        System.out.println(me.mobile.applications);

        System.out.println(me.mobile.isInstalled(facebook));
        System.out.println(me.mobile.isInstalled(messenger));
        System.out.println(me.mobile.isInstalled("facebook"));
        System.out.println(me.mobile.isInstalled("messenger"));
    }
    //1. Create an enum FoodType inside Animal class with values meet/crops/all
    //
    //add final field foodType to Animal class choose it basing on a specie.
    //
    //2. Add switch case to feed method:
    //
    // - in case of omnivores 50% mass of food will be build into body mass
    //
    // - in case of carnivorous 70% mass of food will be build into body mass
    //
    // - in case of herbivorous 30% mass of food will be build into body mass
}
