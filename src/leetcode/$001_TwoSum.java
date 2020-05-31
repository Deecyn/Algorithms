package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deecyn
 * @version 1.0
 * Description: LeetCode No.1 两数之和。
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那「两个」整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class $001_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        return byEnumerate(nums, target);
    }

    /**
     * 将已经遍历过的元素作为目标元素存放在 hash 表中；
     *
     * 在遍历数组的时候，由于正在遍历的元素，其之前的元素均已经存在于 hash 表中，
     * 这时会把当前元素与 hash 表中的元素求和与 target 比较。
     * 若满足要求的元素在当前元素的后面，虽然这时在 hash 表中无法找到，但在以后的对数组的遍历中，会遍历到后面的那个元素
     * 到那时，因为后面的那个元素与当前元素相匹配，则满足题意。即不会漏掉元素。
     */
    public int[] byHashMap(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            Integer x = target - nums[i];

            if (hashMap.containsKey(x)){
                return new int[]{hashMap.get(x), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 使用双重循环，枚举所有可能的结果，时间复杂度 O(n^2)
     */
    public int[] byEnumerate(int[] nums, int target){
        int[] index = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    index[0] = i;
                    index[1] = j;
                    return index;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
