package chapter2.Item4;

//정적 팩토리 방식의 싱글턴 예제
public class Elvis2 {
    private static final Elvis2 INSTANCE = new Elvis2();
    private Elvis2() {}
    
    /* Elvis2.getInstance 는 항상 같은 객체의 참조를 반환하므로 제 2의 Elvis 인스턴스란 결코 만들어지지 않다
    * 리플렉션을 통한 예외는 똑같이 적용
    */
    public static Elvis2 getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {}
    
    /*
    * 정적 팩터리 방식의 첫 장점은 (마음이 바뀌면) API 를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
    * 유일한 인스턴스를 반환하던 팩터리 메서드가 호출하는 스레드별로 다른 인스턴스를 넘겨주게 할 수 있다.
    * 
    * 두 번째 장점은 원한다면 정적 팩터리를 제네릭 싱글턴 팩터리로 만들수 있다는 점이다
    *
    * 둘 중 하나의 방식으로 만든 싱글턴 클래스를 직렬화하려면, 단순히 Serializable 을 구현한다고 선언하는것 만으론 부족하다
    * 모든 인스턴스 필드를 일시적이라고 선언하고 readResolve 메서드를 제공해야한다. 이렇게 하지 않으면 직렬화된 인스턴스를
    * 역질렬화할 때마다 새로운 인스턴스가 만들어진다. Elvis2 의 예제에서라면 가짜 Elvis2가 탄생한다는 뜻이다.
    * 이를 예방하고 싶다면 Elvis2 클래스에 다음의 readResolve 를 추가하자.
    *
    */

    //싱글턴임을 보장해주는 readResolve 메서드
    private Object readResolve() {
        // '진짜' Elvis를 반환하고, 가짜 Elvis는 가비지 컬렉터에 맡긴다.
        return INSTANCE;
    }

}
