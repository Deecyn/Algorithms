package deecyn.recursion;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 70 爬楼梯
 *
 * 在 dynamic_programming 包下查看动态规划解法
 */
public class LC070_ClimbStairs {
    public int climbStairs(int n) {
        return byMemoryRecursion(n, new int[n + 1]);
    }

    /**
     * 记忆化递归，f(n) = f(n-1) + f(n-2)
     * 优化冗余的计算，时间复杂度 O(n)
     */
    public int byMemoryRecursion(int n, int[] memo) {
        // 递归临界条件
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        if (memo[n] > 0) {
            return memo[n];
        }

        return memo[n] = byMemoryRecursion(n - 1, memo) + byMemoryRecursion(n - 2, memo);
    }
}
