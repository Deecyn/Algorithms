package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        int[] numsCopy = new int[n];
        for(int i = 0; i < n; i++){
            numsCopy[i] = nums[i] = sc.nextInt();
        }

        int mid = (n / 2) - 1;
        Arrays.sort(numsCopy);

        for (int i = 0; i < n; i++) {
            if (nums[i] <= numsCopy[mid]) {
                System.out.println(nums[mid + 1]);
            } else {
                System.out.println(nums[mid]);
            }
        }
    }
}
