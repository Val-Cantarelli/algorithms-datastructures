package leetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    @Test
    void testSimpleIncrement() {
        PlusOne plusOne = new PlusOne();
        int[] input = {1, 2, 3};
        int[] expected = {1, 2, 4};
        assertArrayEquals(expected, plusOne.add(input));
    }

    @Test
    void testCarryPropagation() {
        PlusOne plusOne = new PlusOne();
        int[] input = {1, 2, 9};
        int[] expected = {1, 3, 0};
        assertArrayEquals(expected, plusOne.add(input));
    }

    @Test
    void testAllNinesSingleDigit() {
        PlusOne plusOne = new PlusOne();
        int[] input = {9};
        int[] expected = {1, 0};
        assertArrayEquals(expected, plusOne.add(input));
    }

    @Test
    void testAllNinesMultipleDigits() {
        PlusOne plusOne = new PlusOne();
        int[] input = {9, 9, 9};
        int[] expected = {1, 0, 0, 0};
        assertArrayEquals(expected, plusOne.add(input));
    }

    @Test
    void testNoCarry() {
        PlusOne plusOne = new PlusOne();
        int[] input = {4, 5, 6};
        int[] expected = {4, 5, 7};
        assertArrayEquals(expected, plusOne.add(input));
    }
}
