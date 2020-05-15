package leetcode;


/**
 * @author Deecyn
 * @version 1.0
 * Description:
 */
public class $0_Practice {

    public int byGreedy(int[] nums) {
        int currentSum = nums[0];
        int result = currentSum;

        for (int i = 1; i < nums.length; i++) {
            if (currentSum > 0) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }
            result = Math.max(result, currentSum);
        }

        return result;
    }

    public int byDynamic(int[] nums) {
        int currentSum = nums[0];
        int result = currentSum;
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            result = Math.max(result, currentSum);
        }
        return result;
    }


}
