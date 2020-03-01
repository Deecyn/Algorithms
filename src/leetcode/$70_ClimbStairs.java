package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 70 爬楼梯
 */
public class $70_ClimbStairs {
    public int climbStairs(int n) {
//        int[] memo = new int[n + 1];
//        return funD(0, n, memo);

        return funA(n);
    }

    /**
     * 在循环中，向后累加时，只有前两项有用，采用 3 个变量存储实时数据；
     * 时间复杂度 O(n)，空间复杂度 O(1)
     */
    public int funA(int n){
        if (n <= 2) return n;

        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i < n + 1; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    /**
     * 使用循环代替递归，时间复杂度 O(n)，空间复杂度 O(n)
     */
    public int funB(int n){
        if (n <= 2) return n;

        int[] num = new int[n+1];
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }

    /**
     * n 阶楼梯方法数：f(n) = f(n-1) + f(n-2)
     * 采用递归，时间复杂度 O(2^n)，容易超时
     */
    public int funC(int i, int n){
        if (i > n){
            return 0;
        }

        if (i == n){
            return 1;
        }
        return funC(i + 1, n) + funC(i + 2, n);
    }

    /**
     * 记忆化递归，优化冗余的计算，时间复杂度 O(n)
     */
    public int funD(int i, int n, int[] memo){
        if (i > n){
            return 0;
        }

        if (i == n){
            return 1;
        }

        if (memo[i] > 0){
            return memo[i];
        }
        return memo[i] = funD(i + 1, n, memo) + funD(i + 2, n, memo);
    }
}
