package chapter2.Item6;

public class Sum {

    /**
     * 매우 느리다.
     * long 을 Long sum 으로 넣으면서 오토박싱이 일어나고,
     * 불필요한 (Long)i 가 어마어마하게 많이 만들어지는 것이다.
     */
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <=Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int numSets = Integer.parseInt(args[0]);
        long x = 0;

        for (int i=0; i<numSets; i++) {
            long start = System.nanoTime();
            x += sum();
            long end = System.nanoTime();
            System.out.println((end-start)/1_000_000. + " ms.");
        }

        // VM이 최적화하지 못하게 막는 코드
        if (x == 42)
            System.out.println();
    }

}
