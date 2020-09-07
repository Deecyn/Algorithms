package deecyn;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class Test {


    public int binarySearch (int[] array, int low, int high, int target) {
        // write code here
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
