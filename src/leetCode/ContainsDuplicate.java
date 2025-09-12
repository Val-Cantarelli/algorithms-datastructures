package leetCode;
import java.util.HashSet;
import java.util.Set;

/*
EASY
Given an integer array nums and an integer k,
return true if there are two distinct indices i and
j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

======Solutions:
O(n²): Iterate through all pairs (i, j) → too slow
O(n²): Map<Integer, List<Integer>> to track indices → still inefficient
O(n): Map<Integer, Integer> to store only the last index → great for small k, bad for large k
O(n): Sliding Window (Set<Integer> of size k):
✔ The size of the Set already controls the valid window of k positions.
✔ If a number is already in the Set, it has necessarily passed the |i - j| ≤ k condition.
✔ As soon as we find a duplicate number in the Set, we can immediately return true.

====== Tips:
For this problem, Set<Integer> is sufficient and more straightforward.
For systems where we want to avoid manual removal and apply automatic caching policies,
LinkedHashMap is a scalable solution.

*/
public class ContainsDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,7,2,3};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums,k));
    }
}
