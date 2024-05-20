package org.example.reflection;

import java.lang.reflect.Method;

public class ReflectionMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // methods
        Class classTest = Class.forName("org.example.reflection.classTest.FastFood");
        Method putIngredient = classTest.getDeclaredMethod("putIngredient", String.class);
        System.out.println("Find out putIngredient method in FastFood : " + putIngredient);

    }
}
