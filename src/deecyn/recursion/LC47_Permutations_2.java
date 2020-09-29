package deecyn.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class LC47_Permutations_2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return null;

        List<List<Integer>> results = new ArrayList<>(nums.length * nums.length);

        // 进行排序，排序是后面进行剪枝的前提
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayDeque<>(nums.length), results);
        return results;
    }

    public void backtrack(int[] nums, boolean[] used, ArrayDeque<Integer> pathList, List<List<Integer>> results){
        if (pathList.size() == nums.length) {
            results.add(new ArrayList<>(pathList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // 剪枝：
            // i > 0 是为了保证索引 i-1 有意义；
            // nums[i] == nums[i-1] 表示当前元素与上一个元素相等，
            // !used[i-1]：因为之前已经对数组排序过，且回溯过程中会依次对数组中的元素进行遍历，
            //      那么若当前位置的前一个元素的使用标志为 false，则表示该元素曾被使用过，只是在之后的回溯过程中又被撤销使用了。
            // 即搜索到这里的时候，当前的数字组合情况之前已经出现过了，为避免重复，应进行剪枝。
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }

            pathList.addLast(nums[i]);
            used[i] = true;
            backtrack(nums, used, pathList, results);
            used[i] = false;
            pathList.removeLast();
        }
    }

}
