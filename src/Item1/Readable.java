package Item1;

public class Readable {

    /* 정적 팩토리 메소드를 사용하면 이름이 있으므로 생성자에 비해 가독성이 좋다. */

    int intelligence, strength, hitPoint, magicPoint;

    public Readable(int intelligence, int strength, int hitPoint, int magicPoint) {
        this.intelligence = intelligence;
        this.strength = strength;
        this.hitPoint = hitPoint;
        this.magicPoint = magicPoint;
    }

    // 정적 팩토리 메소드
    public static Readable newWarrior() {
        return new Readable(5, 15, 20, 3);
    }

    // 정적 팩토리 메소드
    public static Readable newMage() {
        return new Readable(15, 5, 10, 15);
    }

    // 만약 생성자를 사용해 전사나 마법사를 생성한다면 다음과 같을 것이다.
    Readable warrior_ = new Readable(5,15,20,3);
    Readable mage_ = new Readable(15,5,10,15);

    // 하지만 정적 팩토리 메소드를 사용한다면 좀 더 읽기 쉬운 코드가 된다.
    Readable warrior = Readable.newWarrior();
    Readable mage = Readable.newMage();



}
