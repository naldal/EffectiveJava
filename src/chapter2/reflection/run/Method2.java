package chapter2.reflection.run;

import java.lang.reflect.Method;

// 이름으로 메소드 실행하기
public class Method2 {
    public int add(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) throws Exception{
        Class cls = Class.forName("chapter2.reflection.run.Method2");
        Class partyes[] = new Class[2];
        partyes[0] = Integer.TYPE;
        partyes[1] = Integer.TYPE;
        Method method = cls.getMethod("add", partyes);

        Method2 thisClassObj = new Method2();
        Object argumentList[] = new Object[2];
        argumentList[0] = new Integer(37);
        argumentList[1] = new Integer(47);
        Object retobj = method.invoke(thisClassObj, argumentList);
        Integer retval = (Integer) retobj;
        System.out.println(retval.intValue());

    }
}
