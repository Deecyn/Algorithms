package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $053_MaximumSubarray {


    /**
     * 贪心算法：正数增益法；
     *   对数组进行遍历，设当前最大连续子序列和为 currentSum，结果为 result ；
     *   如果 currentSum > 0，则说明 currentSum 对结果有增益效果，则 currentSum 保留并加上当前遍历数字；
     *   如果 currentSum <= 0，则说明 currentSum 对结果无增益效果，需要舍弃，则 currentSum 直接更新为当前遍历数字；
     *   每次比较 currentSum 和 result，将最大值置为 result，遍历结束返回结果。
     */
    public int byGreedy(int[] nums) {
        int result = nums[0];
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum > 0) {
                currentSum += num;
            } else {
                currentSum = num;
            }
            result = Math.max(result, currentSum);
        }
        return result;
    }

    /**
     * 动态规划算法；
     * 遍历数组，用 nums[i] 表示数组中的第 i 个数，用 f(i) 表示以第 i 个数结尾的「连续子数组的最大和」，
     * 则有：f(i) = max{f(i-1) + nums[i], nums[i]}
     */
    public int byDynamic(int[] nums) {
        // 因为每一项的结果只涉及到前面一项，所以这里用 currentMaxSum 表示 f(i)；
        int currentMaxSum = nums[0];
        int result = currentMaxSum;

        for (int i = 1; i < nums.length; i++) {
            // 这里等号右边的 currentMaxSum 表示 f(i-1)，是等价效果
            currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);
            result = Math.max(currentMaxSum, result);
        }

        return result;
    }
}
