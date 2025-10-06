package leetCode;

import java.util.Arrays;

public class ClimbStairs {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climb(n, memo);
    }

    private int climb(int n, int[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (memo[n] != -1) return memo[n];
        memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int num = 4;
        System.out.println(new ClimbStairs().climbStairs(num));
    }
}
