package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 1.两数之和
 *
 * tags: 数组, 哈希表
 */
public class LC01_TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (hashMap.containsKey(x)) {
                return new int[]{hashMap.get(x), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }

}
