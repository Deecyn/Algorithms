package deecyn.recursion;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 50.Pow(x, n)
 * 实现 pow(x, n)，即计算 x 的 n 次幂函数。
 */
public class LC050_Pow {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        return n < 0 ? fastPow(1.0 / x, -n) : fastPow(x, n);
    }


    /**  分治算法 */
    public double fastPow(double x, int n) {
        if (x == 1 ||  n == 0) return 1.0;

        double sub = fastPow(x, n / 2);

//        return sub % 2 == 0 ? sub * sub : sub * sub * x;
        if (sub % 2 == 0) {
            return sub * sub;
        } else {
            return sub * sub * x;
        }
    }

}
