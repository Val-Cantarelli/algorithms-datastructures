package leetCode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsValidaStrTest {

    IsValidaStr test = new IsValidaStr();

    // Helper for Java < 11
    private static String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder(s.length() * times);
        for (int i = 0; i < times; i++) sb.append(s);
        return sb.toString();
    }

    @Test
    public void testValidSimplePairs() {
        assertTrue(test.isValid("()"));
        assertTrue(test.isValid("()[]{}"));
        assertTrue(test.isValid("([])"));
        assertTrue(test.isValid("{[()]}"));
    }

    @Test
    public void testInvalidMismatch() {
        assertFalse(test.isValid("(]"));
        assertFalse(test.isValid("([)]"));
        assertFalse(test.isValid("{[(])}"));
    }

    @Test
    public void testIncompletePairs() {
        assertFalse(test.isValid("("));
        assertFalse(test.isValid("({"));
        assertFalse(test.isValid("(()"));
        assertFalse(test.isValid("()("));
    }

    @Test
    public void testEmptyString() {
        assertTrue(test.isValid(""));
    }

    @Test
    public void testSingleCloseWithoutOpen() {
        assertFalse(test.isValid("]"));
        assertFalse(test.isValid("}"));
        assertFalse(test.isValid(")"));
    }

    @Test
    public void testLongValidString() {
        String longValid = repeat("({[]})", 1000); // 6000 caracteres válidos
        assertTrue(test.isValid(longValid));
    }

    @Test
    public void testLongInvalidString() {
        String longInvalid = repeat("({[})]", 1000); // estrutura incorreta repetida
        assertFalse(test.isValid(longInvalid));
    }
}
