package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
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
