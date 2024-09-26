package org.example.gofDesign.decorate_pattern;

public class Espresso extends Beverage {

    public Espresso() {
        description = "espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
