package org.example.reflection.classTest;

public class FastFood {
    private final String ingredient = "anything";
    private final String preservative = "yes";

    public FastFood() {
    }

    public void putIngredient(String food) {
        System.out.println(food + "is FastFood");
    }

    public void putPreservative(String food) {
        System.out.println(food + "put preservative");
    }

}
