package leetcode;

import java.util.LinkedList;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $0_Practice {
    /**
     * 关于斐波拉契数列的，递归演示：
     */
    public static int getFactorial(int n) {
        System.out.println("当前n值："+n);
        if (n == 0) {
            System.out.println("if: n = " + n + "，达到临界值");
            return 1;
        } else {
            int prevResult = getFactorial(n - 1);
            int tempResult = n * prevResult;
            System.out.println("else: 当 n = " + n + " 时，" + "prevResult: "+ prevResult + "，tempResult: "+tempResult+"");
            return tempResult;
        }
    }

    public static void main(String[] args) {
        getFactorial(4);
    }

}
