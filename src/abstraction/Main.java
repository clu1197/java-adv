package abstraction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);

        // generic - all animal - Dog Fish can put it in
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "Big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "Big", 75));
        animals.add(new Dog("Pug", "small", 20));

        for (Animal animal: animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal){
                currentMammal.shedHair();
            }
        }

    }

    // any animal can call this method
    private static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("slow");
    }
}