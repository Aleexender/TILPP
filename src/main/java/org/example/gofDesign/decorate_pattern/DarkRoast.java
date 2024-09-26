package org.example.gofDesign.decorate_pattern;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "darkRoast";
    }

    @Override
    public double cost() {
        return .99;
    }
}
