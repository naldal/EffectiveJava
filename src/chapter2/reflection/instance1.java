package chapter2.reflection;

class A {}

public class instance1 {
    public static void main(String[] args) {
        try {
            Class cls = Class.forName("chapter2.reflection.A");

            boolean b1 = cls.isInstance(new Integer(37));
            System.out.println(b1);

            boolean b2 = cls.isInstance(new A());
            System.out.println(b2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
