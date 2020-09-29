package deecyn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 60.第k个排列
 */
public class LC060_PermutationK {

    public String getPermutation(int n, int k) {
        int[] factorials = calculateFactorial(n);

        // 查找全排列需要的布尔数组
        boolean[] used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(n, k, factorials,used,0, path);
        return path.toString();
    }

    private void dfs(int n, int k, int[] factorials, boolean[] used, int index, StringBuilder path) {
        if (index == n){
            return;
        }

        // 计算还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int remainAmount = factorials[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (remainAmount < k) {
                k -= remainAmount;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(n, k, factorials, used, index + 1, path);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }

    }

    /**  计算阶乘数组  */
    private int[] calculateFactorial(int n){
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorials[i] = factorials[i-1] * i;
        }
        return factorials;
    }

}
