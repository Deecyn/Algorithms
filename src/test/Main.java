package test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] wnum = new int[m];
        int idx = 0;
        while (m > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            wnum[idx++] = w;
            m--;
        }

        Arrays.sort(wnum);
        int[] result = new int[3];
        result[0] = Integer.MAX_VALUE;
        for (int i = 0, j = 1; j < wnum.length; i++, j++) {
            int tmp = wnum[j] - wnum[i];

            if (tmp < result[0]) {
                result[0] = tmp;
                result[1] = i;
                result[2] = j;
            }
        }
        System.out.println(result[2] - result[1]);
    }

}
