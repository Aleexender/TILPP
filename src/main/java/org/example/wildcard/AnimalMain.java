package org.example.wildcard;

import java.util.ArrayList;
import java.util.List;

public class AnimalMain {
    public static void main(String[] args) {
        Animal animal = new Dog();
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        animal.makeFriends(dogs);
    }
}
