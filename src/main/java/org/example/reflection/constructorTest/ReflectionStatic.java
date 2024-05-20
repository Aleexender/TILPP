package org.example.reflection.constructorTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.example.staticTest.StaticExample;

public class ReflectionStatic {
    public static void main(String[] args)
        //static method
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException,
        NoSuchFieldException {
        Class staticEx = StaticExample.class;
        Method getNumber = staticEx.getDeclaredMethod("getNumber", int.class);
        Object invoke = getNumber.invoke(Integer.class, 100);
        System.out.println(invoke.toString());

        // static field
            Class staticEx2 = StaticExample.class;
            Field a = staticEx2.getDeclaredField("a");
            a.set(null, 123); // if type is not matched it will throw illegal ArgumentException
            System.out.println(a.get(null));

        }
}
