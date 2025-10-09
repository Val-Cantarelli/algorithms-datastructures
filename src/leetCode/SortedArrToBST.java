package leetCode;
/*
* 108. Convert Sorted Array to Binary Search Tree[Easy]

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced
* binary search tree.
*
 Constraints:
1. 1 <= nums.length <= 104
2. -104 <= nums[i] <= 104
3. nums is sorted in a strictly increasing order.
* */

public class SortedArrToBST {

    public TreeNode sortedArrayToBST(int []nums){

        return helper(0, nums.length-1, nums);
    }
    private TreeNode helper(int start,int end, int []arr){
        if (start >  end) return null;
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = helper(start,mid-1,arr);
        node.right = helper(mid+1, end, arr);

        return node;
    }

    public static void main(String[] args) {
        int [] nums = {1,4,7,9,10};
        System.out.println(new SortedArrToBST().sortedArrayToBST(nums));
    }
}
