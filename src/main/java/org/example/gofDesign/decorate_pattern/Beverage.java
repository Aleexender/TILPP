package org.example.gofDesign.decorate_pattern;

public abstract class Beverage { // normally it should be made by interface
    String description = "제목 없음";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
