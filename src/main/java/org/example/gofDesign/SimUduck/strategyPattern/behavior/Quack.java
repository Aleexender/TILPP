package org.example.gofDesign.SimUduck.strategyPattern.behavior;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("sound like Quack");
    }
}
