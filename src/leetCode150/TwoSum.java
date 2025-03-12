package leetCode150;
/*EASY
Given an array of integers nums and an integer target, return indices of the two numbers
such that they add up to target.

You may assume that each input would have exactly one solution, and you may not
use the same element twice.

You can return the answer in any order.*/

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        int complement,number=0;
        for (int i = 0; i < nums.length; i++){
            number = nums[i];
            complement = target - number;

            if(map.containsKey(complement)){
                return new int[] { map.get(complement), i };
            }
            map.put(number,i);
        }

        return new int[0]; // The problem guarantees a solution
    }

    public static void main(String[] args) {
        int []nums = {3,3};
        int target = 6;
        for(int elem:twoSum(nums,target)){System.out.print(elem);}


    }

}
