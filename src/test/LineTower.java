package test;

import java.util.Scanner;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class LineTower {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[2 * n];
        int[] b = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < 2 * n; i++) {
            b[i] = sc.nextInt();
        }



        int life = 0, minLife = 0;
        int leftIdx = n - 1, rightIdx = n;
        while (true){

            if (leftIdx >= 0 && rightIdx < 2 * n) {
                int leftDiff = b[leftIdx] - a[leftIdx];
                int rightDiff = b[rightIdx] - a[rightIdx];
                if (((leftDiff > rightDiff) || (leftDiff == rightDiff && b[leftIdx] < b[rightIdx]))) {
                    life -= a[leftIdx];

                    minLife = Math.min(life, minLife);

                    life += b[leftIdx];
                    leftIdx--;
                } else {
                    life -= a[rightIdx];
                    minLife = Math.min(life, minLife);

                    life += b[rightIdx];
                    rightIdx++;
                }
            } else if (leftIdx < 0 && rightIdx < 2 * n){
                life -= a[rightIdx];
                minLife = Math.min(life, minLife);

                life += b[rightIdx];
                rightIdx++;
            } else if (rightIdx >= 2 * n && leftIdx >= 0){
                life -= a[leftIdx];

                minLife = Math.min(life, minLife);

                life += b[leftIdx];
                leftIdx--;
            } else {
                break;
            }

        }

        System.out.println(1 - minLife);
    }


}
