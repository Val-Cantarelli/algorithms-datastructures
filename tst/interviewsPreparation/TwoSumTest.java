package interviewsPreparation;
import static org.junit.jupiter.api.Assertions.*;

import leetCode.TwoSum;
import org.junit.jupiter.api.Test;

public class TwoSumTest {
    /*
    Google
    Given an array of integers nums and an integer target, return indices of the two
    numbers such that they add up to target. You may assume that each input would have
    exactly one solution, and you may not use the same element twice. You can return
    the answer in any order.

    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


    */

    @Test
    public void testTwoSum() {

        TwoSum solution = new TwoSum();
        // Case 1: Check if the method returns the correct indices
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {1, 0}; // Because nums[0] + nums[1] = 2 + 7 = 9
        assertArrayEquals(expected1, solution.twoSum(nums1, target1));

        // Case 2: Another example with different numbers
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] expected2 = {2, 1}; // Because nums[1] + nums[2] = 2 + 4 = 6
        assertArrayEquals(expected2, solution.twoSum(nums2, target2));

        // Case 3: Testing with negative numbers
        int[] nums3 = {-1, -2, -3, -4, -5};
        int target3 = -8;
        int[] expected3 = {4, 2}; // Because nums[2] + nums[4] = -3 + -5 = -8
        assertArrayEquals(expected3, solution.twoSum(nums3, target3));

        // Case 4: Check when there is no solution
        int[] nums4 = {1, 2, 3, 4};
        int target4 = 10;
        int[] expected4 = {}; // There are no two numbers that sum up to 10
        assertArrayEquals(expected4, solution.twoSum(nums4, target4));
    }
}
