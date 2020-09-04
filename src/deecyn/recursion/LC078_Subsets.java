package deecyn.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 78.子集
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class LC078_Subsets {

    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return results;
    }

    /**  回溯算法 */
    public void backtrack(int[] nums, int idx, List<Integer> tempList) {
        if (idx == nums.length) {
            results.add(new ArrayList<>(tempList));
            return;
        }

        backtrack(nums, idx + 1, tempList);

        tempList.add(nums[idx]);
        backtrack(nums, idx + 1, tempList);

        tempList.remove(tempList.size() - 1);
    }
}
