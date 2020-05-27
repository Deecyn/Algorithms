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
        Scanner in = new Scanner(System.in);
        String numStr = in.nextLine();
        String[] numStrings = numStr.split(",");
        int[] originNums = new int[numStrings.length];

        int countNegative = 0, count0 = 0, minPositive = 0, maxNegative = Integer.MIN_VALUE;
        for (int i = 0; i < numStrings.length; i++) {
            originNums[i] = Integer.parseInt(numStrings[i]);
            if (originNums[i] < 0) {
                countNegative++;
                maxNegative = Math.max(maxNegative, originNums[i]);
            } else if (originNums[i] > 0) {
                minPositive = Math.min(minPositive, originNums[i]);
            } else {
                count0++;
            }
        }

        if (countNegative > 0 && (countNegative % 2 != 0)) {
            for (int i = 0; i < originNums.length; i++) {
                if (originNums[i] == maxNegative) {
                    System.out.println(i);
                    return;
                }
            }
        } else if (count0 > 0) {
            for (int i = 0; i < originNums.length; i++) {
                if (originNums[i] == 0) {
                    System.out.println(i);
                    return;
                }
            }
        } else {
            for (int i = 0; i < originNums.length; i++) {
                if (originNums[i] == minPositive) {
                    System.out.println(i);
                    return;
                }
            }
        }

    }
}
