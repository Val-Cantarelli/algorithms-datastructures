package leetCode;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int j = 0;
        while(j < nums.length){
            for(int i = j+1; i < nums.length; i++){
                if(nums[j] + nums[i] == target) return new int[] { i, j };
            }
            j++;
        }
        return new int[] {};
    }

}
