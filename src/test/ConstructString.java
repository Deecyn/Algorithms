package test;

import java.util.Scanner;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class ConstructString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int count = 0;
        for (int i = 2; i < str.length(); i++) {
            String s = str.substring(0, i);
            String s_end = str.substring(i);
            if (s_end.length() < s.length()) {
                break;
            }

            if (s_end.contains(s)){
                count = i - 1;
            }
        }
        System.out.println(n - count);

    }
}
