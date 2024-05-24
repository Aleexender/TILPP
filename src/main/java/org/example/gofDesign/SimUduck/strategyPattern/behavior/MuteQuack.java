package org.example.gofDesign.SimUduck.strategyPattern.behavior;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("it can not say quack");
    }
}
