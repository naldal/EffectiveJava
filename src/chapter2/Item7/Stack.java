package chapter2.Item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * 메모리 누수 발생 위험지역.
     * 이 코드에서는 스택이 커졌다가 줄어들었을 때 스택에서 꺼내진 객체들을 가비지 컬렉터가 회수하지 않는다.
     * 프로그램에서 그 객체들을 더 이상 사용하지 않더라도 말이다.
     *
     * 이 스택이 그 객체들의 다 쓴 참조(obsolete reference)를 여전히 가지고 있기 때문이다.
     * 여기서 다 쓴 참조란 문자 그대로 앞으로 다시 쓰지 않을 참조를 뜻한다.
     */
    public Object pop() {
        if(size==0) {
            throw new EmptyStackException();
        }
        /** 해법 : 해당 참조를 다 썼을 때 null 처리(참조 해제) 하면 된다. */
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
