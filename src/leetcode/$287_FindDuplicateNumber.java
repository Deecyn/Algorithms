package leetcode;

/**
 * @author Deecyn
 * @version 0.14
 * Description:
 */
public class $287_FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int min = 1, max = len - 1, mid = -1;
        while (min < max) {
            // 当 min + max 的结果溢出的时候，无符号右移可以保证结果仍然正确
            mid = (min + max) >>> 1;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
