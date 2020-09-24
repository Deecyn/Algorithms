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
        backtrack(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> pathList, List<List<Integer>> results) {
        if (pathList.size() == nums.length) {
            results.add(new ArrayList<>(pathList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            pathList.add(nums[i]);
//            System.out.println("  递归之前 => " + pathList);
            backtrack(nums, visited, pathList, results);

            visited[i] = false;
            pathList.remove(pathList.size() - 1);
//            System.out.println("递归回退之后 => " + pathList);
        }
    }

    public static void main(String[] args) {
//        System.out.println(permute(new int[]{1, 2, 3}));
    }

}
