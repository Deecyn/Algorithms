package deecyn;

import deecyn.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description:
 */
public class Test {

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return null;

        List<List<Integer>> results = new ArrayList<>(nums.length * nums.length);
        backtrack(nums, new boolean[nums.length], new ArrayList<>(nums.length), results);
        return results;
    }

    public void backtrack(int[] nums, boolean[] visited, List<Integer> pathList, List<List<Integer>> results){
        if (pathList.size() == nums.length){
            results.add(new ArrayList<>(pathList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            pathList.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, pathList, results);
            visited[i] = false;
            pathList.remove(pathList.size() - 1);
        }
    }

}
