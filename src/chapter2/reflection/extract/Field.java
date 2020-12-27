package chapter2.reflection.extract;

import java.lang.reflect.Modifier;

public class Field {
    private double d;
    public static final int i = 37;
    String s = "testing";

    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Class.forName("chapter2.reflection.extract.Field");
        java.lang.reflect.Field fieldList[] = cls.getDeclaredFields();
        for (int i=0; i<fieldList.length; i++) {
            java.lang.reflect.Field fld = fieldList[i];

            System.out.println("name = "+fld.getName());
            System.out.println("declared class = "+fld.getDeclaringClass());
            System.out.println("type = "+fld.getType());
            
            // 제어자 얻기
            int mod = fld.getModifiers();
            System.out.println("modifiers = "+ Modifier.toString(mod));
            System.out.println("----");
        }
    }
}
