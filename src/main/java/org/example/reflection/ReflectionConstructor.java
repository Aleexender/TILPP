package org.example.reflection;

import java.lang.reflect.Constructor;
import org.example.reflection.classTest.Burger;

public class ReflectionConstructor {
    public static void main(String[] args) throws NoSuchMethodException {
        //constructor
        Class findClass = Burger.class;
        Constructor constructor = findClass.getDeclaredConstructor();
        Constructor[] constructor2 = findClass.getDeclaredConstructors();
        System.out.println("Constructor "+constructor.getName());

        for (Constructor constructor1 : constructor2) {
            System.out.println(constructor1);
        }
    }
}
