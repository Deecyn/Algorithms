package leetcode;


import java.util.*;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $0_Practice {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public int climbStairs(int n) {
        if (n < 3) return n;

        int[] results = new int[n + 1];
        results[1] = 1;
        results[2] = 2;
        for (int i = 3; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }

        return results[n];
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>(nums.length / 3);

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;

            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1, targetSum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == targetSum) {
                        results.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[++low]);
                        while (low < high && nums[high] == nums[--high]);
                    } else if (nums[low] + nums[high] < targetSum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }

        }

        return results;
    }

    public static void main(String[] args) {

    }
}
