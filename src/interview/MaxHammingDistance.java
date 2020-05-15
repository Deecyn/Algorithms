package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 *
 * 题目描述：
 * 给出n个数，求这n个数中两两最大的汉明距离
 *
 * 两个数的汉明距离定义为两个数的二进制表示中不同的位数。
 *
 * 例如11和6的汉明距离为3，因为11转换为二进制后为1011，6转换为二进制后为0110，他们的二进制第1,3,4位（从低位开始数）不同。
 *
 * 输入
 * 第一行一个数n，代表有n个数
 *
 * 接下来n个数，描述这n个数a1, a2 , .. ,an
 *
 * 1≤n≤100      1≤ ai ≤10000
 *
 * 输出
 * 一个数，最大的汉明距离
 *
 *
 * 样例输入
 * 3
 * 1 2 3
 * 样例输出
 * 2
 */
public class MaxHammingDistance {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        int min = 0, max = 0, maxPower2 = 0, maxPower2Idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                min = nums[i];
                break;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] % 2 == 0) {
                maxPower2 = nums[i];
                break;
            }
        }

        String binMin = toBinaryStr(min);
        String binMax = toBinaryStr(maxPower2 + 1);
        int count = 0;
        for (int i = 0; i < binMax.length(); i++) {
            if (i < binMin.length() && binMin.charAt(i) != binMax.charAt(i)) {
                count++;
            } else if (binMax.charAt(i) != '0') {
                count++;
            }
        }
        System.out.println(count);
    }

    public static String toBinaryStr(int x) {
        StringBuilder binaryStr = new StringBuilder();
        while (x > 0) {
            binaryStr.append(x % 2);
            x = x/2;
        }
        return binaryStr.reverse().toString();
    }
}
