package org.example.gofDesign.SimUduck.strategyPattern.behavior;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("it can not fly");
    }
}
