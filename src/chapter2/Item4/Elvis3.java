package chapter2.Item4;

// 열거타입 방식의 싱글턴 - 바람직한 방법
public enum Elvis3 {
    INSTANCE;

    public void leaveTheBuilding(){}
    /*
    * public 방식과 비슷하지만, 더 간결하고, 추가노력 없이 직렬화할 수 있고, 심지어 아주 복잡한 직렬화 상황이나 리플렉션 공격에서도
    * 제2의 인스턴스가 생기는 일을 완벽하게 막아준다. 조금 부자연스러워 보일 수는 있으나 대부분 상황에서는 원소가 하나뿐인
    * 열거타입이 싱글턴을 만드는 가장 좋은 방법이다.
    *
    * 단 만들려는 싱글턴이 Enum 외의 클래스를 상속해야 한다면 이 방법은 사용할 수 없다.
    */
}
