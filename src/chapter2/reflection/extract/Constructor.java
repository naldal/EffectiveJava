package chapter2.reflection.extract;

public class Constructor {

    public Constructor() {}
    protected Constructor(int i, double d) {}

    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Class.forName("chapter2.reflection.extract.Constructor");

        java.lang.reflect.Constructor ctorlist[] = cls.getDeclaredConstructors();
        for (int i=0; i<ctorlist.length; i++) {
            java.lang.reflect.Constructor ct = ctorlist[i];

            System.out.println("name = "+ct.getName());
            System.out.println("declared name = "+ct.getDeclaringClass());

            Class pvec[] = ct.getParameterTypes();
            for (int j=0; j<pvec.length; j++) {
                System.out.println("param #"+j+" "+pvec[j]);
            }

            Class evec[] = ct.getExceptionTypes();
            for (int k=0; k<evec.length; k++) {
                System.out.println("exception #"+k+" "+evec[k]);
            }

            System.out.println("----");
        }
    }
}
