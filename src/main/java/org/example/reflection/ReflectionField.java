package org.example.reflection;

import java.lang.reflect.Field;

public class ReflectionField {
    public static void main(String[] args) throws ClassNotFoundException {
        //field
        Class clzz = Class.forName("org.example.reflection.classTest.Burger");
        SecurityManager securityManager = new SecurityManager();
        Field[] fields = clzz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

    }
}
