package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $045_JumpGame2 {

    /**
     * 贪心算法；
     */
    public int byGreedy(int[] nums) {
        // 跳跃边界的索引
        int jumpBorderIndex = 0;
        // 当前可以跳的最远的位置索引
        int currentFurthestIndex = 0;
        // 跳跃的次数
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            currentFurthestIndex = Math.max(currentFurthestIndex, i + nums[i]);
            if (i == jumpBorderIndex) {
                jumpBorderIndex = currentFurthestIndex;
                steps++;
            }
        }

        return steps;
    }
}
