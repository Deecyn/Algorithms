package leetcode;

import java.util.*;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $0_Practice {

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public int byIterationVar(int n){
        if (n < 3) return n;

        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public int byIteration(int n){
        if (n < 3) return n;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public int byRecursion(int i, int n){
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }

        return byRecursion(i + 1, n) + byRecursion(i + 2, n);
    }

    public int byMemoryRecursion(int i, int n, int[] memo){
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }

        if (memo[i] > 0){
            return memo[i];
        }

        return memo[i] = byMemoryRecursion(i + 1, n, memo) + byMemoryRecursion(i + 2, n, memo);
    }


    public static void main(String[] args) {

    }
}
