package sword_means_offer;

/**
 * @author Deecyn
 * @version 0.15
 * Description: 剑指offer 第 64 题。
 *  求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class $064_SumOfN {

    public int sumNums(int n) {
        boolean flag = (n > 0 && (n += sumNums(n - 1)) > 0);
        return n;
    }

    /**
     * 脑洞方式：通过是否抛出异常来判断。
     *   很耗费时间！！
     */
    int[] test0 = new int[]{0};
    public int byException(int n) {
        try {
            // 当 n != 0 时，访问数组下标越界，抛出异常
            return test0[n];
        } catch (Exception e) {
            return n + sumNums(n - 1);
        }
    }

}
