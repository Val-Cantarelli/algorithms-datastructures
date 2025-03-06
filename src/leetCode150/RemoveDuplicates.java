package leetCode150;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]){
                i++;
            }
            nums[i] = nums[j];
        }
        return nums;
    }
    public static void main(String[] args) {
            int[] nums = {0,1,1,1,2,3};
            int []arr = removeDuplicates(nums);
            for(int elem:arr) System.out.print(elem + " ");
    }

}
