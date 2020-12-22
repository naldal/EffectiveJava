package chapter2.Item2;

import java.math.BigInteger;

public class NoNeedToNewObj {

    /*
        Readable 의 마법사와 전사를 만드는 코드는 정적 팩터리 메소드를 호출할 때마다 new Readable(...) 을 호출하게 된다.
        그러나 immutable 객체를 캐시해서 쓰고 있다면 굳이 일일히 new 같은 비싼 연산을 사용할 필요가 없다.
        다음은 개요에서 호출 코드의 예로 사용했던 java.mathBigInteger.valueOf 메소드의 코드이다.
    */


    public static final BigInteger ZERO = new BigInteger(new byte[0]);
    // 미리 객체를 생성해놓음


    private final static int MAX_CONSTANT = 16;
    private static BigInteger posConst[] = new BigInteger[MAX_CONSTANT+1];
    private static BigInteger negConst[] = new BigInteger[MAX_CONSTANT-1];

    public static BigInteger valueOf(long val) {
        // 분기에 따라 이미 생성된 객체사용 (immutable Object)
        if (val == 0)
            return ZERO;
        if (val > 0 && val <= MAX_CONSTANT)
            return posConst[(int) val];
        else if (val < 0 && val >= -MAX_CONSTANT)
            return negConst[(int) -val];

        return new BigInteger(String.valueOf(val));
    }

}
