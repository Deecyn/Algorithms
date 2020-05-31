package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description: LeetCode No.11 盛最多水的容器。
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class $011_MostWaterContainer {

    public int maxArea(int[] height){
        return byEnumerate(height);
    }

    /**
     * 枚举所有情况，时间复杂度 O(n^2)
     */
    public int byEnumerate(int[] height){
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i],height[j]);
                max = Math.max(area,max);
            }
        }
        return max;
    }

    /**
     * 使用双指针遍历，左右边界 i、j 向中间收敛
     * 时间复杂度为 O(n)
     */
    public int byDoublePointer(int[] height){
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int area = (j - i + 1) * minHeight;
            max = Math.max(max,area);
        }
        return max;
    }
}
