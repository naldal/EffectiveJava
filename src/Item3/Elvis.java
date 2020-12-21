package Item3;

// 싱글턴 예제
public class Elvis {

    // public static final 필드 방식의 싱글턴
    public static final Elvis INSTANCE = new Elvis();

    /* private 생성자는 public static final 필드인 Elvis.INSTANCE 를 초기화할 때 딱 한번만 호출된다.
    * public이나 protected 생성자가 없으므로 Elvis 클래스가 초기화될 때 만ㄷ르어진 인스턴스가 전체 시스템에서 하나뿐임을
    * 보장한다. 클라이언트가 손 쓸 방법이 없다.
    *
    * 하지만 권한이 있는 클라이언트는 리플렉션 API AccessibleObject.setAccessible을 이용해 private 생성자를 호출할 수 있다.
    * 이러한 공격을 방어하려면 생성자를 수정하여 두 번째 객체가 생성되려 할 때 예외를 던지게 하면 된다.
    */
    private Elvis() {
        System.out.println("blah blah");
    }
}
