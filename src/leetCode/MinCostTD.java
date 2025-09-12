package leetCode;

import java.util.Arrays;
/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
* */
public class MinCostTD {
    private int[] memo;
    private int[] cost;

    public MinCostTD(int[] cost) {
        this.cost = cost;
        this.memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 0;
    }

    public int optimalCost(int index) {

        if(memo[index] != -1)return memo[index];
        int result = Math.min ((optimalCost(index -1) + cost[index -1]),
                optimalCost(index-2)+ cost[index-2]);
        memo[index] = result;
        return result;
    }

    public static void main(String[] args) {
        int [] cost = {10,15,20, 24};
        MinCostTD minCostTD = new MinCostTD(cost);
        System.out.println(minCostTD.optimalCost(cost.length));
    }
}