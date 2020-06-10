package leetcode;

/**
 * @author Deecyn
 * @version 0.15
 * Description:
 */
public class $009_PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int left = x;
        int right = 0;
        while (left > right) {
            right = right * 10 + left / 10;
            left /= 10;
        }

        return left == right || left == right / 10;
    }

    /**
     * 通过将整数转化为字符数组，通过双指针遍历解决
     */
    public boolean byToString(int x) {
        String numStr = String.valueOf(x);

        char[] chars = numStr.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过数学运算分解数字来验证
     */
    public boolean byMathResolve(int x) {
        if (x < 0) return false;

        // divisor 表示数字 x 的位数，为每次取整操作的除数
        int divisor = 1;
        while (x / divisor >= 10) divisor *= 10;

        while (x > 0) {
            // 通过取整操作取数字 x 左边的最高位
            int left = x / divisor;
            // 通过取余操作取数字 x 右边的最低位
            int right = x % 10;

            // 判断首尾数字是否相等
            if (left != right) {
                return false;
            }

            // 更新数字 x 的值，通过取余操作去掉最高位，通过取整操作去掉最低位
            x = (x % divisor) / 10;
            // 更新 divisor 的值，因为上面数字 x 去掉了首尾两位数，所有这里应该除以 100
            divisor /= 100;
        }
        return true;
    }
}
