package leetcode;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $50_PowXN {

    public double myPow(double x, int n) {
        if (n == 0) return 1D;

        int m = Math.abs(n);
        double sum = x;

        while (m > 1) {
            sum *= x;
            m--;
        }
        if (n < 0) sum = 1D / sum;

        return sum;
    }
}
