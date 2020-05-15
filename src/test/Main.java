package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(2);
        } else {
            long result = 2L << (n - 1);
            System.out.println(result);
        }
    }

}
