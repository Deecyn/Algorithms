package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Deecyn
 * @version 1.0
 * Description: 小明在凌空SOHO上班，想通过爬楼梯的方式锻炼。他爬楼梯的方式有3种，
 *   一步跨一层、一步跨二层或一步跨三层，但是由于身体原因，在爬楼梯的锻炼中，一步跨三层的方式只能使用一次，
 *   请问爬到第K层楼梯时共有多少种方式？
 *
 * 输入：输入一个整型数，表示楼梯级数
 * 输出：输出一个整型数，表示爬到该级数的方式个数。若有任何异常，则返回 -1.
 */
public class ClimbStairs {


    static int climb(int n) {
        if (n < 0) return -1;
        if (n <= 2) return n;
        if (n == 3) return 4;


        int[] num = new int[n+1];
        int threeSum = 0;
        num[1] = 1;
        num[2] = 2;
        num[3] = 4;
        for (int i = 4; i < n + 1; i++) {
            num[i] = num[i - 1] + num[i - 2];
            threeSum += num[i - 3];
        }
        return num[n] + threeSum;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = climb(_n);
        System.out.println(String.valueOf(res));
    }
}
