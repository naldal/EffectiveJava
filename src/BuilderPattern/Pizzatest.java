package BuilderPattern;

import static BuilderPattern.Pizza.Topping.*;
import static BuilderPattern.NyPizza.Size.*;

// 계층적 빌더 사용 (21쪽)
public class Pizzatest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();

        System.out.println(pizza);
        System.out.println(calzone);
    }
}
