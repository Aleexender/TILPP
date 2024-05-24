package org.example.gofDesign.SimUduck.strategyPattern.duck;

import org.example.gofDesign.SimUduck.strategyPattern.behavior.FlyWithWings;
import org.example.gofDesign.SimUduck.strategyPattern.behavior.Quack;

public class MallarDuck extends Duck{

    public MallarDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("looks like Mallar");
    }
}
