package chapter3.Item10;

import java.util.Objects;

public class Equals {

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));
    }
    
    /** 
     * equals 메서드를 재정의할 때는 반드시 일반 규약을 따라야 한다. 다음은 Object 명세에 적힌 규약이다
     * 반사성 : null 이 아닌 모든 참조 값 x 에 대해, x.equals(x) 는 true 이다.
     * 대칭성 : null 이 아닌 모든 참조 값 x,y 에 대해, x.equals(y) 가 true 면 y.equals(x) 도 true 다.
     * 추이성 : null 이 아닌 모든 참조 값 x,y z 에 대해 x.equals(y) 가 true 고 y.equals(z) 도 true 면 x.equals(z) 도 true 다.
     * 일관성 : null 이 아닌 모든 참조 값 x,y 에 대해 x.equals(y) 를 반복해서 호출하면 항상 true 를 반환하거나 항상 false 를 반환한다.
     * null-아님: null 이 아닌 모든 참조 값 x 에 대해, x.equals(null) 은 false 다.
     */
    
}

// 잘못된 코드 - 대칭성 위배
final class CaseInsensitiveString {
    private final String s;

    CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }
    
    // 대칭성 위배!
/*
    @Override public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString)o).s);
        if (o instanceof String) 
            return s.equalsIgnoreCase((String) o);
        return false;
        
    }
*/
    // ... 나머지 코드 생략
    /**
     * 예를 들어, 다음처럼 CaseInsensitiveString 과 일반 String 객체가 하나씩 있다고 해보자.
     * CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
     * String s = "polish";
     * 
     * cis.equals(s)는 true를 반환하지만, String의 equals는 CaseInsensitive 의 기능이 존재하지 않는다.
     * 따라서 s.equals(cis)는 false를 반환하게 되고 이것은 대칭성을 명백히 위반한다
     */

    /**
     * 이 문제를 해결하려면 CaseInsensitiveString 의 equals를 String과도 연동하겠다는 허황된 꿈을 버려야한다.
     * 그 결과 equals는 다음과 같은 모습으로 바뀐다.
     */

    @Override public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);
    }

}
