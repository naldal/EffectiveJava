package chapter2.Item5.abstractPkgBase;

public class Main {

    public static void main(String[] args) {
        Player cdPlayer = new CDPlayer();
        cdPlayer.play(11);

        cdPlayer.pause();
        cdPlayer.play();
    }

}
