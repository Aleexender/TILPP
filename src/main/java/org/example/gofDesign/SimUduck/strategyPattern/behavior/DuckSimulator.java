package org.example.gofDesign.SimUduck.strategyPattern.behavior;

import org.example.gofDesign.SimUduck.strategyPattern.duck.Duck;
import org.example.gofDesign.SimUduck.strategyPattern.duck.MallarDuck;
import org.example.gofDesign.SimUduck.strategyPattern.duck.ModelDuck;

public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallarDuck();
        mallard.performFly();
        mallard.performQuack();

        Duck model = new ModelDuck();
        model.performFly(); // it is going to start with FlyNoWay class
        model.setFlyBehavior(new FlyRocketPowered()); // out of the class will give the FlyRocketPowered class
        model.performFly();
    }
}
