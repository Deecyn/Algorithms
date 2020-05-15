package interview;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */

public class EditString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int q = 0;
        StringBuilder strb = new StringBuilder();
        Stack<String> strStack = new Stack<>();

        while (N > 0) {
            q = in.nextInt();
            switch (q) {
                case 1:
                    String w = in.next();
                    strStack.push(strb.toString());
                    strb.append(w);
                    break;
                case 2:
                    int deleteIdx = in.nextInt();
                    strStack.push(strb.toString());
                    strb.delete(strb.length() - deleteIdx, strb.length());
                    break;
                case 3:
                    int getIdx = in.nextInt();
                    char ch = strb.toString().charAt(getIdx - 1);
                    System.out.println(ch);
                    break;
                case 4:
                    strb = new StringBuilder(strStack.pop());
                    break;
            }
            N--;
        }

    }
}
