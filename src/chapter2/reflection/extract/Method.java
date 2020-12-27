package chapter2.reflection.extract;

public class Method {
    private int f1(Object p, int x) throws NullPointerException {
        if (p == null)
            throw new NullPointerException();
        return x;
    }

    public static void main(String[] args) {
        try {
            Class cls = Class.forName("chapter2.reflection.extract.Method");

            java.lang.reflect.Method[] methodList = cls.getDeclaredMethods();
            for (int i = 0; i<methodList.length; i++) {
                java.lang.reflect.Method m = methodList[i];
                System.out.println("name = "+m.getName());
                System.out.println("declared class = "+m.getDeclaringClass());

                Class pvec[] = m.getParameterTypes();
                for (int j=0; j<pvec.length; j++) {
                    System.out.println("param #"+j+" "+pvec[j]);
                }

                Class evec[] = m.getExceptionTypes();
                for(int k=0; k<evec.length; k++) {
                    System.out.println("exe #"+k+" " +evec[k]);
                }

                System.out.println("return type = "+m.getReturnType());
                System.out.println("----");


            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
