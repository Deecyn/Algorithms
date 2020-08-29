package deecyn.dynamic_programming;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 70 爬楼梯
 *
 * 在 recursion 包下查看递归解法
 */
public class LC070_ClimbStairs {
    public int climbStairs(int n) {
//        return byMemoryRecursion(n, new int[n + 1]);

        return byIterationVar(n);
    }

    /**
     * 在循环中，向后累加时，只有前两项有用，采用 3 个变量存储实时数据；
     * 时间复杂度 O(n)，空间复杂度 O(1)
     */
    public int byIterationVar(int n){
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
    public int byIteration(int n){
        if (n <= 2) return n;

        int[] num = new int[n+1];
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }

}
