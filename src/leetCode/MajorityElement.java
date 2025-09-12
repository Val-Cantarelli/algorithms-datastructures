package leetCode;

/*
Algorithm Used: Implements the Boyer-Moore Voting Algorithm, which finds the majority element in
O(n) time and 𝑂(1) space.
Definition of Majority Element: A number that appears more than n/2 times in an array of size





*/
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate=0;
        int count =0;
        for(int elem:nums){
            if(count ==0){
                candidate = elem;
            }
            count+= (elem==candidate) ? 1 : -1;
        }
        return candidate;
    }
    public static void main(String[] args) {
        int []arr = {1,1,1,1,2,2,2,2,2,5,5,5,5,5,5,1,1,1,1};
        System.out.println(majorityElement(arr));
    }

}
