package deecyn.recursion;

import java.util.*;

/**
 * @author Deecyn
 * @version 0.1
 * Description: LeetCode 39.组合总和
 */
public class LC039_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        // 排序，方便后续进行剪枝
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayDeque<>(), results);
        return results;
    }

    public void backtrack(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> results) {

        // 由于进入更深层的时候，小于 0 的部分已被剪枝，因此递归终止条件只判断等于 0 的情况
        if (target == 0) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {

            /*
             * 剪枝：
             * 在候选数组已经有序的前提下，
             * 如果 target 减去一个数等于负数，那么减去一个更大的数依然是负数，是搜索不到结果的，需要进行剪枝
             */
            if (target - candidates[i] < 0){
                break;
            }

            path.addLast(candidates[i]);
            // 每一个元素可以重复使用；但不能再次使用前面的元素，避免出现重复的结果，所以下一轮搜索的起点为 i 。
            backtrack(candidates, i,target - candidates[i], path, results);
            path.removeLast();
        }
    }
}
