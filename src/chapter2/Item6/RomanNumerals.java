package chapter2.Item6;

import java.util.regex.Pattern;

public class RomanNumerals {

    /**
     * String.matches 는 정규표현식으로 문자열 형태를 확인하는 가장 쉬운 방법이지만,
     * 성능이 중요한 상황에서 반복해서 쓰기에는 적합하지 않다.
     *
     * 이 메서드가 내부에서 만드는 정규표현식용 Pattern 인스턴스는, 한번 쓰고 버려져서 곧바로 가비지 컬렉션이 된다.
     * Pattern 은 입력받은 정규표현식에 해당하는 유한상태(finite state machine) 을 만들기 때문에 인스턴스 생성비율이 높다.
     */
    static boolean isRomanNumeral_(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /**
     * 성능을 개선하려면 필요한 정규표헌식을 표현하는 (불변) Pattern 인스턴스를 클래스 초기화(정적초기화) 과정에서 직접 캐싱해두고
     * 나중에 isRomanNumeral 메서드가 호출될 때마다 이 인스턴스를 재사용한다.
     */

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }

    /**
     * 이렇게 개선하면 isRomanNumeral 이 빈번히 호출되는 상황에서 성능을 상당히 끌어올릴 수 있다.
     * 성능 뿐만 아니라 코드도 더 명확해졌다.
     * 개선전에는 존재조차 몰랐던 Pattern 인스턴스를 static final 필드로 끄집어내고 이름을 지어주어 코드의 의미가 훨씬 잘 드러난다.
     */
}
