package leetCode;
//EASY
/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and
two integers m and n, representing the number of elements in nums1 and nums2
respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored
inside the array nums1. To accommodate this, nums1 has a length of m + n, where the
first m elements denote the elements that should be merged, and the last n elements are
 set to 0 and should be ignored. nums2 has a length of n.
==============================================================
 SOLUTION O(m + n)
- Merge nums2 into nums1 in-place (no extra arrays);
- nums1 already has enough space (extra zeros at the end);
- Fill from back to front (to avoid overwriting elements).

- Use three pointers:
i: The current position in nums1 where the next element will be placed
j: The current position in nums2 being compare
k: The current position in nums1 being compared
- Compare nums1[m] and nums2[n], place the larger one in nums1[i], and move the pointers.
- If nums2 still has elements, just copy them into nums1 in the correct position.
 */

public class MergedSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n ==0)return;
        int i = m + n -1;
        int j = m-1;
        int k = n -1;

        while(j >= 0 && k >= 0){
            if(nums2[k] >= nums1[j]){
                nums1[i] = nums2[k];
                k--;
            }
            else {
                nums1[i] = nums1[j];
                j--;
            }
            i--;
        }

        while (k >= 0) {
            nums1[i] = nums2[k];
            k--;
            i--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);

        for (int elem:nums1){
            System.out.print(elem + " ");
        }

    }
}
