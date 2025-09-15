package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
************************************************
You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
That is, each element of nums is covered by exactly one of the ranges, and there is no
integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b



*/
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) return list;

        int start = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (start == nums[i]) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + "->" + nums[i]);
                }

                if (i != nums.length - 1) {
                    start = nums[i + 1];
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int []nums = {0,6,7,8};
        System.out.println(summaryRanges(nums));

    }

    //EASY
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }

        public static void main(String[] args) {
            ListNode node1 = new ListNode(3);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(0);
            ListNode node4 = new ListNode(-4);

            node1.next=node2;
            node2.next=node3;
            node3.next=node4;
            node4.next = node2;


            System.out.println(hasCycle(node1));
        }
        public static boolean hasCycle(ListNode head) {
            if(head == null) return false;
            Set<ListNode> set = new HashSet<>();


            ListNode curent = head;
            set.add(curent);
            while (curent.next != null){
                if(set.contains(curent))return true;
                set.add(curent);
                curent = curent.next;
            }


            return true;
        }
    }

    public static class TwoSum {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();

            int complement,number=0;
            for (int i = 0; i < nums.length; i++){
                number = nums[i];
                complement = target - number;

                if(map.containsKey(complement)){
                    return new int[] { map.get(complement), i };
                }
                map.put(number,i);
            }

            return new int[0]; // The problem guarantees a solution
        }

        public static void main(String[] args) {
            int []nums = {3,3};
            int target = 6;
            for(int elem:twoSum(nums,target)){System.out.print(elem);}


        }

    }
}
