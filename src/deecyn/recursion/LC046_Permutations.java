package deecyn.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 46.全排列
 */
public class LC046_Permutations {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, new int[nums.length], new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, int[] visited, List<Integer> tempList, List<List<Integer>> results) {
        if (tempList.size() == nums.length) {
            results.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;

            visited[i] = 1;
            tempList.add(nums[i]);
            backtrack(nums, visited, tempList, results);

            visited[i] = 0;
            tempList.remove(tempList.size() - 1);
        }
    }

}
