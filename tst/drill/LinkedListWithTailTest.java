package drill;

import java.util.Iterator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListWithTailTest {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        LinkedListWithTail<Integer> list = new LinkedListWithTail<>(3);

        list.add(0);
        list.add(1);
        list.add(1);


        for (int i = 3; i <= n; i++) {
            Iterator<Integer> iterator = list.iterator();
            int t0 = iterator.next();
            int t1 = iterator.next();
            int t2 = iterator.next();
            int nextValue = t0 + t1 + t2; // Tn+3 = Tn + Tn+1 + Tn+2
            list.add(nextValue);
        }

        return list.getTailValue();
    }

    @Test
    public void testTribonacciBaseCases() {
        assertEquals(0, tribonacci(0), "T(0) should be 0");
        assertEquals(1, tribonacci(1), "T(1) should be 1");
        assertEquals(1, tribonacci(2), "T(2) should be 1");
    }

    @Test
    public void testTribonacciGeneralCases() {
        assertEquals(4, tribonacci(4), "T(4) should be 4");
        assertEquals(7, tribonacci(5), "T(5) should be 7");
        assertEquals(13, tribonacci(6), "T(6) should be 13");
        assertEquals(24, tribonacci(7), "T(7) should be 24");
        assertEquals(44, tribonacci(8), "T(8) should be 44");
        assertEquals(81, tribonacci(9), "T(9) should be 81");
        assertEquals(149, tribonacci(10), "T(10) should be 149");
    }

    @Test
    public void testTribonacciWithHigherN() {
        assertEquals(927, tribonacci(13), "T(13) should be 504");
        assertEquals(10609, tribonacci(17), "T(17) should be 3136");
    }
}
