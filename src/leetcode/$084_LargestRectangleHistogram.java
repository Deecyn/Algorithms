package leetcode;

import java.util.LinkedList;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public class $084_LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> idxStack = new LinkedList<>();
        int[] newHeights = new int[heights.length + 2];

/*        for (int i = 1; i < heights.length + 1; i++) {
            newHeights[i] = heights[i - 1];
        }*/
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        int maxArea = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!idxStack.isEmpty() && newHeights[idxStack.peek()] > newHeights[i]) {
                int currIdx = idxStack.pop();
                maxArea = Math.max(maxArea, (i - idxStack.peek() - 1) * newHeights[currIdx]);
            }
            idxStack.push(i);
        }
        return maxArea;
    }
}
