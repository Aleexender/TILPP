package org.example.gofDesign.decorate_pattern;

public class HouseBlend extends  Beverage{

    public HouseBlend() {
        description = "houseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
