package Item1;

public class OrderUtil {

    /*
        리턴하는 객체의 타입을 유연하게 지정할 수 있다.
        다음은 어느 가상의 인터넷 쇼핑몰에서 할인 코드를 처리하는 정적 팩토리 메서드이다.
    */

    public static Discount createDiscountItem(String discountCode) throws Exception {
        if(!isValidCode(discountCode)) {
            throw new Exception(("잘못된 할인코드드"));
        }

        // 쿠폰 코드인가? 포인트 코드인가?
        if (isUsableCoupon(discountCode)) {
            return new Coupon(1000);
        } else if (isUsablePoint(discountCode)) {
            return new Point(500);
        }
        throw new Exception("이미 사용한 코드");
    }

    private static boolean isValidCode(String discountCode) {
        return discountCode.equals("right value");
    }
    private static boolean isUsableCoupon(String discountCode) {
        return discountCode.equals("coupon");
    }
    private static boolean isUsablePoint(String discountCode) {
        return discountCode.equals("point");
    }

    /*
        할인 코드의 규칙에 따라 Coupon 과 Point 객체를 선택적으로 리턴하고 있다.
        이를 위해서는 두 하위 클래스가 같은 인터페이스를 구현하거나, 같은 부모 클래스를 갖도록 하면된다.
        만약 파일을 분리하기 애매한 작은 클래스가 있다면 private class 를 활용할 수도 있다.
    */

}

class Discount {}
class Coupon extends Discount {
    int v;
    public Coupon(int v) {
        this.v = v;
    }
}
class Point extends Discount {
    int v;
    public Point(int v) {
        this.v = v;
    }
}
