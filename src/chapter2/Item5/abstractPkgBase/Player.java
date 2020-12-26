package chapter2.Item5.abstractPkgBase;

abstract class Player {

    boolean pause;  // 일시정지 상태 저장변수
    int currentPos; // 현재 Play되고 있는 위치를 저장하기 위한 변수

    Player() {
        pause = false;
        currentPos = 0;
    }

    /* 지정된 위치(pos)에서 재생을 시작하는 기능이 수행되도록 해야한다. */
    abstract void play(int currentPos);
    abstract void stop();

    void play() {           // 추상메서드를 사용할 수 있다.
        play(currentPos);
    }

    void pause() {
        if(pause) {
            pause = false;
            play(currentPos);
        } else {
            pause = true;
            stop();
        }
    }


}
