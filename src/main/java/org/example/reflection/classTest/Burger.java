package org.example.reflection.classTest;

public class Burger extends FastFood {


    private String ingredient = "meat";
    private final String preservative = "yes";
    public int a = 0;

    public Burger() {
    }

    private Burger(String food) {
        this.ingredient = food;
    }

    public String putIngredientMore(String food) {
        System.out.println(food + "is Burger");
        return food;
    }

    public String putPreservativeMore(String food) {
        System.out.println(food + "put preservative more");
        return food;
    }

}
