package test;

import java.util.Scanner;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class SJB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        char[][] tLetters = new char[t][4];

        for(int i = 0; i < t; i++){
            for (int j = 0; j < 4; j++) {
                tLetters[i][j] = sc.next().toCharArray()[0];
            }
        }

        for (char[] tLetter : tLetters) {
            int countLeft = countWin(tLetter[0], tLetter[2]) + countWin(tLetter[0], tLetter[3]);
            int countRight = countWin(tLetter[1], tLetter[2]) + countWin(tLetter[1], tLetter[3]);

            if (countLeft > countRight) {
                System.out.println("left");
            } else if (countLeft < countRight) {
                System.out.println("right");
            } else {
                System.out.println("same");
            }
        }

    }

    private static int countWin(char sisterLetter, char brotherLetter) {
        if (sisterLetter == brotherLetter) {
            return 0;
        } else if (sisterLetter == 'S' && brotherLetter == 'J') {
            return 1;
        } else if (sisterLetter == 'S' && brotherLetter == 'B') {
            return 0;
        } else if (sisterLetter == 'J' && brotherLetter == 'S') {
            return 0;
        } else if (sisterLetter == 'J' && brotherLetter == 'B') {
            return 1;
        } else if (sisterLetter == 'B' && brotherLetter == 'J') {
            return 0;
        } else if (sisterLetter == 'B' && brotherLetter == 'S') {
            return 1;
        }
        return 0;
    }


}
