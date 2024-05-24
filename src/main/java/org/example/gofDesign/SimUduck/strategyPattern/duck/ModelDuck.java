package org.example.gofDesign.SimUduck.strategyPattern.duck;

import org.example.gofDesign.SimUduck.strategyPattern.behavior.FlyNoWay;
import org.example.gofDesign.SimUduck.strategyPattern.behavior.Quack;

public class ModelDuck extends Duck {

    public ModelDuck() {
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("i am model duck");
    }
}
