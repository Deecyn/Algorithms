package sword_means_offer;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $029_SpiralPrintMatrix {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];

        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        int[] results = new int[(right + 1) * (bottom + 1)];
        int idx = 0;
        while (true) {
            // 在顶部的行，从最左列遍历到最右列
            for (int i = left; i <= right; i++) {
                results[idx++] = matrix[top][i];
            }

            // 排除掉上面遍历过的顶部行，top 的值应不能大于 bottom 的值
            if (++top > bottom) break;
            // 在最右边的列，从顶部行遍历到底部行
            for (int i = top; i <= bottom; i++) {
                results[idx++] = matrix[i][right];
            }

            // 排除掉上面遍历过的最右列，left 的值应不能大于 right 的值
            if (left > --right ) break;
            // 在底部的行，从最右列遍历到最左列
            for (int i = right; i >= left; i--) {
                results[idx++] = matrix[bottom][i];
            }

            // 排除掉上面遍历过的底部行，top 的值应不能大于 bottom 的值
            if (top > --bottom) break;
            // 在最左边的列，从底部行遍历到顶部行
            for (int i = bottom; i >= top; i--) {
                results[idx++] = matrix[i][left];
            }

            // 排除掉上面遍历过的最左列，left 的值应不能大于 right 的值
            if (++left > right) break;
        }
        return results;
    }

}
