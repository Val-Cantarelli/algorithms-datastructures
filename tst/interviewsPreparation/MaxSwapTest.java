package interviewsPreparation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetCode.MaxSwap;
import org.junit.jupiter.api.Test;
public class MaxSwapTest {

    @Test
    public void testAlreadyMaximized() {
        assertEquals(9876, getMaximizedNumber(9876));
    }

    @Test
    public void testSingleDigitNumber() {
        assertEquals(5, getMaximizedNumber(5));
    }

    @Test
    public void testSimpleSwap() {
        assertEquals(7236, getMaximizedNumber(2736));
    }

    @Test
    public void testNumberWithRepeatedDigits() {
        assertEquals(9913, getMaximizedNumber(1993));
    }

    @Test
    public void testNoSwapNeeded() {
        assertEquals(7651, getMaximizedNumber(7651));
    }

    @Test
    public void testLargeNumber() {
        assertEquals(9798, getMaximizedNumber(8799));
    }

    @Test
    public void testEdgeCaseTwoDigits() {
        assertEquals(91, getMaximizedNumber(19));
    }

    // Método auxiliar para reconstruir o número a partir do array
    private int getMaximizedNumber(int num) {
        int[] arr = MaxSwap.maximumSwap(num);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result * 10 + arr[i];
        }
        return result;
    }
}
