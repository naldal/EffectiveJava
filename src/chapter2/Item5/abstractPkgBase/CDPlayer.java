package chapter2.Item5.abstractPkgBase;

public class CDPlayer extends Player {
    @Override
    void play(int pos) {
        System.out.println(pos+"초에 시작되었습니다");
        pos++;
        pos++;
        stop();
    }

    @Override
    void stop() {
        System.out.println("종료되었습니다");
    }
}
