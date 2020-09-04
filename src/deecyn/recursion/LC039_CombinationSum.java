package deecyn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 39.组合总和
 */
public class LC039_CombinationSum {

    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return results;

        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new LinkedList<>());
        return results;
    }

    /**  回溯法 */
    public void backtrack(int[] candidates, int target, int nextBegin, LinkedList<Integer> pathList) {
        if (target == 0) {
            results.add(new ArrayList<>(pathList));
            return;
        }

        for (int i = nextBegin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            pathList.addLast(candidates[i]);
            backtrack(candidates,target - candidates[i], i, pathList);
            pathList.removeLast();
        }
    }
}
