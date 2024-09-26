package org.example.wildcard;

import java.util.List;

public class Dog implements Animal{

    @Override
    public void makeFriends(List<? extends Animal> animals) {

    }
}
