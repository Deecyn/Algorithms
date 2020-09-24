package test;

import java.util.Scanner;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class ConstructTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) return;

        int[] trees = new int[n + 1];
        trees[0] = 1;
        trees[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                trees[i] += trees[j - 1] * trees[i - j];
            }
        }
        System.out.println(trees[n]);
    }
}
