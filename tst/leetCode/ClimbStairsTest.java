package leetCode;

import leetCode.ClimbStairs;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsTest {

    @Test
    void testClimbStairs() {
        ClimbStairs cs = new ClimbStairs();
        assertEquals(1, cs.climbStairs(1));
        assertEquals(2, cs.climbStairs(2));
        assertEquals(3, cs.climbStairs(3));
        assertEquals(5, cs.climbStairs(4));
        assertEquals(8, cs.climbStairs(5));
    }
}