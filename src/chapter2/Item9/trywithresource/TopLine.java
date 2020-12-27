package chapter2.Item9.trywithresource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {

    static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }

    /**
     * try-with-resources 버전이 짧고 읽기 쉬울 뿐 아니라 문제를 진단하기도 훨씬 좋다.
     * readLine 과 (코드에 없는) close 호출 양쪽에서 예외가 발생하면, close 에서 발생한 예외는 숨겨지고
     * readLine 에서 발생한 예외가 기록된다.
     * 이처럼 실전에서는 프로그래머에게 보여줄 예외 하나만 보존되고 여러개의 다른 예외가 숨겨질 수 있다.
     */
}
