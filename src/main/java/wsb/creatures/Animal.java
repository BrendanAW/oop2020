package wsb.creatures;

import wsb.database.Connector;
import wsb.food.FoodType;

import java.io.File;
import java.sql.SQLException;

public class Animal implements Feedable, Comparable<Animal> {
    final String species;
    private Double weight;
    public String name;
    File pic;
    private final FoodType foodType;

    private static Double NEW_DOG_WEIGHT = 4.0;
    private static Double NEW_LION_WEIGHT = 39.2;
    private static Double NEW_OTHER_ANIMAL_WEIGHT = 5.3;

    private static Double DEFAULT_FEED_WEIGHT = 1.0;

    public Animal(String species, FoodType foodType) {
        this.foodType = foodType;
//        System.out.println("we created new Animal");
        this.species = species;

        switch (species) {
            case "dog": {
                weight = NEW_DOG_WEIGHT;
                break;
            }
            case "lion": {
                weight = NEW_LION_WEIGHT;
                break;
            }
            default: {
                weight = NEW_OTHER_ANIMAL_WEIGHT;
                break;
            }
        }
//        try {
//            this.save();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public Animal(String species, Double weight, FoodType foodType) {
        this.weight = weight;
        this.species = species;
        this.foodType = foodType;
        try {
            this.save();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void feed() {
        feed(DEFAULT_FEED_WEIGHT, foodType);
    }


    public void feed(Double foodWeight, FoodType foodType) {
        if (weight == 0) {
            System.out.println("too late, " + name + " is dead");
            return;
        }
        if (!foodType.equals(this.foodType))
            return;
        weight = foodWeight * foodType.getFoodToBodyRatio();
        System.out.println(name + " says thx for food");

    }

    public void takeForAWalk() {
        if (weight == 0.0) {
            System.out.println("you can't walk the street with dead animal you freak");
        } else if (weight > 3.0) {
            --weight;
            System.out.println(name + " says thx for a walk");
        } else if (weight > 1.0) {
            --weight;
            System.out.println(name + " says thx for a walk but I'm hungry");
        } else {
            weight = 0.0;
            System.out.println(name + " died");
        }
    }

    public Double getWeight() {
        return weight;
    }

    protected void kill() {
        System.out.println("byeeeeeeeeeeeeee");
        this.weight = 0.0;
    }

    public String toString() {
        return "Hi I'm an Animal " + this.species + " " + this.name;
    }

    @Override
    public int compareTo(Animal o) {
        return this.species.compareTo(o.species);
    }

    public void save() throws SQLException {
        String sql = "insert into animal values ('" + this.species + "','" + this.name + "'," + this.weight + ");";
        System.out.println(sql);
        Connector.executeSQL(sql);
    }

    //3. add field foodToBodyRatio to enum FoodType
    //
    //4. redo feed method
    //
    //
    //
    //5. change method feed to get foodType as a parameter, if it doesn't fit to animal there should be a text information and no body mass gain
    //6. will it be better now to move FoodType outside the Animal class? so move it out :)

}
