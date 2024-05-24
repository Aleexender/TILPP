package org.example.gofDesign.SimUduck.strategyPattern.behavior;

public class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("it can fly");
    }
}
