package leetCode;
//EASY
/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of
the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the
following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
The remaining elements of nums are not important as well as the size of nums.
Return k.

Custom Judge:
The judge will test your solution with the following code:
int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.
==============================================================
 SOLUTION
Two indexes:
i → Represents the element that will be moved to the right (when it equals val).
j → Represents the element that will be moved to the left (when it is different from val).
Loop logic:
1. While i < j, keep searching for elements to swap.
2. If nums[i] == val, move j to find a valid number (nums[j] ≠ val).
3. If i == j, stop (break), because no more swaps are possible.

Note: When a swap occurs, i is incremented.
However, if no swap happens, we need break to ensure i correctly represents the count of elements
that remain on the left (i.e., elements that are not val).
 */

public class RemoveElement {
    public static int removeElement(int[] nums, int val){
        if(nums.length ==0) return 0;
        int j = nums.length;
        int i;
        for(i=0;i < j;i++) {
            if(nums[i] == val){
                j = j-1;
                while (j > i && nums[j] == val) {
                    j--;
                }
                if(i==j) break;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        return i;
    }
    public static void main(String[] args) {
        int [] nums = {1,2};
        int val = 2;
        int k = removeElement(nums,val);
        for (int elem:nums)  System.out.print(elem + " ");
        System.out.println("k: "+ k);
    }
}
