package leetcode;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $238_ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] results = new int[len];

        // 此时 results[i] 表示索引 i 左侧所有元素的乘积；
        // 因为索引为 0 的元素左侧没有元素，所以 results[0] = 0。
        results[0] = 1;
        for (int i = 1; i < len; i++) {
            results[i] = nums[i - 1] * results[i - 1];
        }

        // right 表示当前元素的右侧所有元素的乘积，刚开始右边没有元素，所以 right = 1。
        int right = 1;
        // 注意，这里的终止条件应该是 i >= 0 。
        for (int i = len - 1; i >= 0; i--) {
            // 对于索引为 i 的元素，其左边元素的乘积为 results[i]，右边元素的乘积为 right。
            results[i] = results[i] * right;
            // 将当前值乘到 right 上，以更新 right 的值，用于下一个索引元素的计算
            right = right * nums[i];
        }
        return results;
    }
}
