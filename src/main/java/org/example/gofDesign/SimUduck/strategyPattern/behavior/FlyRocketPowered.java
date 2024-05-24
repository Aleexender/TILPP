package org.example.gofDesign.SimUduck.strategyPattern.behavior;

public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("fly with rocket");
    }
}
