package deecyn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 51. N 皇后问题
 */
public class LC051_NQueens {

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessboard[i], '.');
        }

        List<List<String>> results = new ArrayList<>(n);
        backtrack(0, chessboard, results);
        return results;
    }

    /**  回溯算法 */
    private void backtrack(int row, char[][] chessboard, List<List<String>> results) {
        // 终止条件：遍历完了棋盘的最后一行，说明已经生成了一种解决方案
        if (row == chessboard.length) {
            results.add(boardToList(chessboard));
            return;
        }

        // 遍历该行的每一列
        for (int col = 0; col < chessboard.length; col++) {
            // 排除不合法的选择
            if (!isValid(chessboard, row, col)) {
                continue;
            }

            // 进行选择
            chessboard[row][col] = 'Q';
            // 进入下一行做决策
            backtrack(row + 1, chessboard, results);
            // 退回到该位置时，说明当前方案无效，撤销选择
            chessboard[row][col] = '.';
        }

        // 该行的列遍历完了，说明没有有效的解决方案，此时退回到上一行
    }

    /**  判断是否可以在 chessboard[row][column] 位置放皇后 */
    private boolean isValid(char[][] chessboard, int row, int column) {
        // 判断当前列有没有皇后：
        // 因为我们是一行一行往下遍历的，所以我们只需要检查走过的行数即可，
        // 也就是说，判断当前位置的上面有没有放置皇后即可
        for (int i = 0; i < row; i++) {
            if (chessboard[i][column] == 'Q') {
                return false;
            }
        }

        // 判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = column + 1; i >= 0 && j < chessboard.length ; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /** 将棋盘转化成题目要求的字符串列表 */
    private List<String> boardToList(char[][] chessboard) {
        List<String> path = new ArrayList<>();
        for (char[] chars : chessboard) {
            path.add(new String(chars));
        }
        return path;
    }
}














