package leetCode;

public class SingleOne {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i =0; i< nums.length-1; i++){
            result= result^ nums[i];
            String binValue = Integer.toBinaryString(result);
            System.out.println(binValue);
            System.out.println();
        }
        return result;
    }
    public static void main(String[] args) {
        SingleOne singleOne = new SingleOne();
        int result = singleOne.singleNumber(new int[]{2,3, 1});
        System.out.println(result);
    }
}
