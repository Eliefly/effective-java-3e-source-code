package effectivejava.chapter2.item6;

// Hideously slow program! Can you spot the object creation? (Page 24)
public class Sum {
    private static long sumLong() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    private static long sumlong() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

        // int numSets = Integer.parseInt(args[0]);
        int numSets = 5;
        long x = 0;
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sumLong();
            long end = System.nanoTime();
            System.out.println((end - start) / 1000000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42) {
            System.out.println();
        }

        System.out.println("======================");

        x = 0;
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += sumlong();
            long end = System.nanoTime();
            System.out.println((end - start) / 1000000. + " ms.");
        }
    }
}