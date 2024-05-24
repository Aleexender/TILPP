package org.example.gofDesign.SimUduck.strategyPattern.behavior;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("sound like rubber Quack");
    }
}
