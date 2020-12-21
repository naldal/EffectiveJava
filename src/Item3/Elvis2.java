package Item3;

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
    * 정적 팩터리 방식의 첫 장점은 (마음이 바뀌면) API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
    * 유일한 인스턴스를 반환하던 팩터리 메서드가 호출하는 스레드별로 다른 인스턴스를 넘겨주게 할 수 있다.
    * 
    * 두 번째 장점은 원한다면 정적 팩터리를 제네릭 싱글턴 팩터리로 만들수 있다는 점이다
    */

}
