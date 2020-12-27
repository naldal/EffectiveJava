package chapter2.reflection.run;

import java.lang.reflect.Constructor;

// 새로운 객체 만들기
public class Construct2 {

    public Construct2() {}
    public Construct2(int a, int b) {
        System.out.println("a = "+a+" b = "+b);
    }

    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("chapter2.reflection.run.Construct2");
        Class partypes[] = new Class[2];
        partypes[0] = Integer.TYPE;
        partypes[1] = Integer.TYPE;

        Constructor ct = cls.getConstructor(partypes);
        Object argumentList[] = new Object[2];
        argumentList[0] = new Integer(37);
        argumentList[1] = new Integer(47);
        Object retobj = ct.newInstance(argumentList);
        System.out.println(retobj instanceof Construct2);
    }

}
