package leetCode75;
/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of
nums except nums[i].The product of any prefix or suffix of nums is guaranteed to fit in
a 32-bit integer. You must write an algorithm that runs in O(n) time and without using the division
operation.
*/

public class ProductExceptSelf {
    private static int[] productExceptSelf(int[] nums) {
        int []answer=new int[nums.length];
        answer[0]=1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i-1]* nums[i-1];
        }
        int product = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            answer[i] *= product;
            product *=  nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int [] finalResult = productExceptSelf(nums);

        for(int elem:finalResult) System.out.print(elem + ",");

    }
}
