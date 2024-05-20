package org.example.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import org.example.reflection.classTest.Burger;
import sun.reflect.ReflectionFactory;

public class ReflectionClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //class
        Class findClass = Burger.class;
        System.out.println("Class name " + findClass.getName());


        Class findClass2 = Class.forName("org.example.reflection.classTest.Burger");
        System.out.println("Class name "+findClass2.getName());


    }

}
