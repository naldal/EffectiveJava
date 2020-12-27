package chapter2.reflection.run;

import java.lang.reflect.Array;

public class Array1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Class.forName("java.lang.String");
        Object arr = Array.newInstance(cls, 10);
        System.out.println(arr.getClass());
        Array.set(arr, 1, "is this one?");
        Array.set(arr, 5, "this is test");
        String s = (String) Array.get(arr, 1);
        System.out.println(s);
    }
}
