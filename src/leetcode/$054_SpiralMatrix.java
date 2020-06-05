package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $054_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> results = new ArrayList<>(matrix.length);

        int row = matrix.length;
        int col = matrix[0].length;
        int level = (Math.min(row, col) + 1) / 2;

        return null;
    }

    public List<Integer> spiralOrder_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int top = 0, bottom  = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> results = new ArrayList<>(matrix.length * matrix[0].length);

        while (true) {
            for (int i = left; i <= right ; i++) {
                results.add(matrix[top][i]);
            }

            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                results.add(matrix[i][right]);
            }

            if (left > --right) break;
            for (int i = right; i >= left; i--) {
                results.add(matrix[bottom][i]);
            }

            if (top > --bottom) break;
            for (int i = bottom; i >= top ; i--) {
                results.add(matrix[i][left]);
            }

            if (++left > right) break;
        }
        return results;
    }

}
