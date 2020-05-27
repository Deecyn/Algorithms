package leetcode;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public class $69_SqrtX {

    /**
     * 二分查找法
     */
    public static int byBinarySearch(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        // 为了防止 mid 的平方值溢出，这里使用 long
        long left = 1, right = x / 2, mid = -1 ;
        while (left < right) {
            mid = (left + right) / 2;
            if (mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right * right > x ? (int)right - 1 : (int)right;
    }

    /**
     * 牛顿迭代法
     */
    public int byNewtonIteration(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) >> 1;
        }
        return (int) x;
    }

}
