package interview;

import java.util.Scanner;
public class DifferentCharNums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder strb = new StringBuilder(in.next());

        int N = in.nextInt();
        while (N > 0) {
            int q = in.nextInt();
            switch (q) {
                case 1:
                    int pos = in.nextInt();
                    String s = in.next();
                    strb.replace(pos - 1, pos, s);
                    break;
                case 2:
                    int l = in.nextInt();
                    int r = in.nextInt();
                    String subStr = strb.substring(l - 1, r);
                    System.out.println(countChar(subStr));
                    break;
            }
            N--;
        }
    }

    public static int countChar(String str) {
        int length = str.length();
        String sub0 = "", sub1 = "", sub2 = "", sub3 = "";
        if (length <= 1000) {
            sub0 = str;
        }
        if (length > 1000 && length < 5000) {
            sub1 = str.substring(3000, 4000);
        }
        if (length > 20000) {
            sub2 = str.substring(12000,13000);
        }
        if (length > 60000) {
            sub3 = str.substring(51000,52000);
        }

        int count = 0;
        int charNum = 97;
        while (charNum <= 122) {
            if (sub0.contains(String.valueOf((char) charNum))) {
                count++;
            } else if (!sub1.isEmpty() && sub1.contains(String.valueOf((char) charNum))) {
                count++;
            } else if (!sub2.isEmpty() && sub2.contains(String.valueOf((char) charNum))) {
                count++;
            } else if (!sub3.isEmpty() && sub3.contains(String.valueOf((char) charNum))) {
                count++;
            } else if (str.contains(String.valueOf((char) charNum))) {
                count++;
            }
            charNum++;

            if (count == 26) return count;
        }
        return count;
    }

}
