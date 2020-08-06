package leetcode;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $209_MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int[] prefixSum = new int[nums.length];

        prefixSum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        int preMinSum = 0, minSubLen = 0;
        for (int i = 0; i < nums.length; i++) {
        }

        return 0;
    }
}
